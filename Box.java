import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiGraphics;

public class Box {
        public Box(int beginX, int beginY, int endX, int endY) {
                this.beginX = beginX;
                this.beginY = beginY;
                this.endX = endX;
                this.endY = endY;
        }

        public Box addBox(
                        int relativelyBeginX,
                        int relativelyBeginY,
                        int relativelyEndX,
                        int relativelyEndY) {
                Box box = new Box(
                                relativelyBeginX + this.beginX,
                                relativelyBeginY + this.beginY,
                                relativelyEndX + this.beginX,
                                relativelyEndY + this.beginY);
                this.boxesList.add(box);
                return box;
        }

        public Box addVisualBox(
                        int relativelyBeginX,
                        int relativelyBeginY,
                        int relativelyEndX,
                        int relativelyEndY) {
                Box box = new Box(
                                relativelyBeginX + this.beginX,
                                relativelyBeginY + this.beginY,
                                relativelyEndX + this.beginX,
                                relativelyEndY + this.beginY);
                box.type = BoxType.VISUAL;
                this.boxesList.add(box);
                return box;
        }

        public Box addCenterBox(int width, int height, int beginY) {
                int newBoxBeginX = (this.getWidth() - width) / 2;
                return this.addVisualBox(
                                newBoxBeginX,
                                beginY,
                                newBoxBeginX + width,
                                beginY + height);
        }

        public Box addCenterVisualBox(int width, int height, int beginY) {
                Box box = this.addCenterBox(width, height, beginY);
                box.type = BoxType.VISUAL;
                return box;
        }

        public Box addInventoryBox(int beginX, int beginY, int InventoryLines, int InventoryCols) {
                Box box = this.addBox(
                                beginX,
                                beginY,
                                beginX + (InventoryCols * 18),
                                beginY + (InventoryLines * 18));
                box.type = BoxType.INVENTORY;
                return box;
        }

        public int getWidth() {
                return this.endX - this.beginX;
        }

        public int getHeight() {
                return this.endY - this.beginY;
        }

        public static int fromPc(int pos, float parcent) {
                return Double.valueOf(pos * (parcent / 100)).intValue();
        }

        private void renderNormalBox(GuiGraphics guiGraphics) {
                /// 取前不取后

                // 上方白色部分
                guiGraphics.fill(
                                this.beginX + 1,
                                this.beginY + 1,
                                this.endX - 2,
                                this.beginY + 3,
                                0xFFFFFFFF);
                // 左边白色部分
                guiGraphics.fill(
                                this.beginX + 1,
                                this.beginY + 1,
                                this.beginX + 3,
                                this.endY - 2,
                                0xFFFFFFFF);

                // 下方灰条
                guiGraphics.fill(
                                this.beginX + 3,
                                this.endY - 2,
                                this.endX,
                                this.endY,
                                0xFF555555);
                // 右边灰条
                guiGraphics.fill(
                                this.endX - 2,
                                this.beginY + 3,
                                this.endX,
                                this.endY,
                                0xFF555555);

                // 左边黑线
                guiGraphics.fill(
                                this.beginX,
                                this.beginY + 2,
                                this.beginX + 1,
                                this.endY - 2,
                                0xFF000000);
                // 左上角那个黑点
                guiGraphics.fill(
                                this.beginX + 1,
                                this.beginY + 1,
                                this.beginX + 2,
                                this.beginY + 2,
                                0xFF000000);
                // 上方黑线
                guiGraphics.fill(
                                this.beginX + 2,
                                this.beginY,
                                this.endX - 2,
                                this.beginY + 1,
                                0xFF000000);
                // 左下角那两个黑点的左上那个
                guiGraphics.fill(
                                this.beginX + 1,
                                this.endY - 2,
                                this.beginX + 2,
                                this.endY - 1,
                                0xFF000000);
                // 左下角那两个黑点的右下那个
                guiGraphics.fill(
                                this.beginX + 2,
                                this.endY - 1,
                                this.beginX + 3,
                                this.endY,
                                0xFF000000);
                // 下方黑线
                guiGraphics.fill(
                                this.beginX + 3,
                                this.endY,
                                this.endX - 1,
                                this.endY + 1,
                                0xFF000000);
                // 右下黑点
                guiGraphics.fill(
                                this.endX - 1,
                                this.endY - 1,
                                this.endX,
                                this.endY,
                                0xFF000000);
                // 右边黑线
                guiGraphics.fill(
                                this.endX,
                                this.beginY + 3,
                                this.endX + 1,
                                this.endY - 1,
                                0xFF000000);
                // 右上两个黑点的左上那个
                guiGraphics.fill(
                                this.endX - 2,
                                this.beginY + 1,
                                this.endX - 1,
                                this.beginY + 2,
                                0xFF000000);
                // 右上两个黑点的右下那个
                guiGraphics.fill(
                                this.endX - 1,
                                this.beginY + 2,
                                this.endX,
                                this.beginY + 3,
                                0xFF000000);

                // 左下角灰点
                guiGraphics.fill(
                                this.beginX + 2,
                                this.endY - 2,
                                this.beginX + 3,
                                this.endY - 1,
                                0xFFc5c5c5);
                // 右上角灰点
                guiGraphics.fill(
                                this.endX - 2,
                                this.beginY + 2,
                                this.endX - 1,
                                this.beginY + 3,
                                0xFFc5c5c5);

                // 主要部分
                guiGraphics.fill(
                                this.beginX + 3,
                                this.beginY + 3,
                                this.endX - 2,
                                this.endY - 2,
                                0xFFc5c5c5);

                // 主要部分左上的那个额外白点
                guiGraphics.fill(
                                this.beginX + 3,
                                this.beginY + 3,
                                this.beginX + 4,
                                this.beginY + 4,
                                0xFFFFFFFF);
                // 主要部分右下的那个额外深灰色像素点
                guiGraphics.fill(
                                this.endX - 3,
                                this.endY - 3,
                                this.endX - 2,
                                this.endY - 2,
                                0xFF555555);
        }

        private void renderInventoryBox(GuiGraphics guiGraphics) {
                int nlines = (this.endY - this.beginY) / 18;
                int ncols = (this.endX - this.beginX) / 18;
                // 渲染每格
                for (int nline = 0; nline < nlines; ++nline) {
                        for (int ncol = 0; ncol < ncols; ++ncol) {
                                int blockBeginX = this.beginX + ncol * 18;
                                int blockBeginY = this.beginY + nline * 18;
                                // 左边褐色条
                                guiGraphics.fill(
                                                blockBeginX,
                                                blockBeginY,
                                                blockBeginX + 2,
                                                blockBeginY + 17,
                                                0xFF373737);
                                // 上边褐色条
                                guiGraphics.fill(
                                                blockBeginX,
                                                blockBeginY,
                                                blockBeginX + 17,
                                                blockBeginY + 1,
                                                0xFF373737);
                                // 右上灰点
                                guiGraphics.fill(
                                                blockBeginX + 17,
                                                blockBeginY,
                                                blockBeginX + 18,
                                                blockBeginY + 1,
                                                0xFF8a8a8a);
                                // 右边白条
                                guiGraphics.fill(
                                                blockBeginX + 17,
                                                blockBeginY + 1,
                                                blockBeginX + 18,
                                                blockBeginY + 18,
                                                0xFFffffff);
                                // 下边白条
                                guiGraphics.fill(
                                                blockBeginX + 1,
                                                blockBeginY + 17,
                                                blockBeginX + 18,
                                                blockBeginY + 18,
                                                0xFFffffff);
                                // 左下灰点
                                guiGraphics.fill(
                                                blockBeginX,
                                                blockBeginY + 17,
                                                blockBeginX + 1,
                                                blockBeginY + 18,
                                                0xFF8a8a8a);
                                // 主要部分
                                guiGraphics.fill(
                                                blockBeginX + 1,
                                                blockBeginY + 1,
                                                blockBeginX + 17,
                                                blockBeginY + 17,
                                                0xFF8a8a8a);
                        }
                }
        }

        private void render(GuiGraphics guiGraphics) {
                switch (this.type) {
                        case BoxType.NORMAL:
                                this.renderNormalBox(guiGraphics);
                                break;
                        case BoxType.INVENTORY:
                                this.renderInventoryBox(guiGraphics);
                                break;
                        default:
                                break;
                }
        }

        public void renderTo(GuiGraphics guiGraphics) {
                this.render(guiGraphics);
                for (Box box : this.boxesList) {
                        box.render(guiGraphics);
                }
        }

        public List<Box> boxesList = new ArrayList<Box>();

        public int beginX;
        public int beginY;
        public int endX;
        public int endY;

        BoxType type = BoxType.NORMAL;
}

enum BoxType {
        NORMAL,
        VISUAL,
        INVENTORY
}
