# MinecraftGuiCreator
It can help you to create a dynamic rendering GUI.(rathar than texture pack.)

NeoForged commit 412c6ab (Minecraft 1.21, 2024/6/24) 

# Using

For example, if you input something in the game chat, you can get a dynamic rendering GUI.
```java
@EventBusSubscriber(modid = Fall.MODID, value = Dist.CLIENT)
public class Client {
        @SubscribeEvent
        public static void onClientChatEvent(ClientChatEvent event) {
                Minecraft.getInstance().setScreen(new TestGUI(Component.translatable("test")));
        }
}

final class TestGUI extends Screen {

        public TestGUI(Component pTitle) {
                super(pTitle);
        }

        @Overwrite
        public void init() {

        }

        @Override
        public void render(
                        @Nonnull GuiGraphics pGuiGraphics,
                        int pMouseX,
                        int pMouseY,
                        float pPartialTick) {
                this.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

                super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

                pGuiGraphics.drawString(font, Integer.toString(pMouseX) + " " + Integer.toString(pMouseY), pMouseX,
                                pPartialTick, pMouseY, isDragging());
                Box box = new Box(0, 0, pMouseX, pMouseY);
                Box ibox = box.addInventoryBox(box.endX - 10 - 3 * 18, box.endY - 10 - 3 * 18, pMouseY / 100, pMouseX / 100);
                Box vbox = box.addCenterVisualBox(20, 20, 50);

                box.renderTo(pGuiGraphics);

                pGuiGraphics.drawString(font, "Test", vbox.beginX, vbox.beginY, 0xffffffff, isDragging());

        }

}

```
