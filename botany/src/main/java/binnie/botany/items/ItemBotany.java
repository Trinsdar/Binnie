package binnie.botany.items;

import binnie.botany.CreativeTabBotany;
import forestry.api.core.IItemModelRegister;
import forestry.api.core.IModelManager;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBotany extends Item implements IItemModelRegister {

	public ItemBotany(String registryName) {
		setRegistryName(registryName);
		setTranslationKey(registryName);
		setCreativeTab(CreativeTabBotany.INSTANCE);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModel(Item item, IModelManager manager) {
		manager.registerItemModel(item, 0);
	}
}
