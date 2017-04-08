package binnie.extratrees.integration.jei;

import binnie.core.integration.jei.Drawables;
import binnie.extratrees.integration.jei.brewery.BreweryRecipeCategory;
import binnie.extratrees.integration.jei.brewery.BreweryRecipeMaker;
import binnie.extratrees.integration.jei.distillery.brewery.DistilleryRecipeCategory;
import binnie.extratrees.integration.jei.distillery.brewery.DistilleryRecipeMaker;
import binnie.extratrees.integration.jei.fruitpress.FruitPressRecipeCategory;
import binnie.extratrees.integration.jei.fruitpress.FruitPressRecipeMaker;
import binnie.extratrees.integration.jei.lumbermill.LumbermillRecipeCategory;
import binnie.extratrees.integration.jei.lumbermill.LumbermillRecipeMaker;
import binnie.extratrees.machines.ExtraTreeMachine;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;

@JEIPlugin
public class ExtraTreesJeiPlugin extends BlankModPlugin {
	public static IJeiHelpers jeiHelpers;
	public static IGuiHelper guiHelper;
	public static Drawables drawables;

	@Override
	public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

	}

	@Override
	public void register(IModRegistry registry) {
		ExtraTreesJeiPlugin.jeiHelpers = registry.getJeiHelpers();
		ExtraTreesJeiPlugin.guiHelper = jeiHelpers.getGuiHelper();
		ExtraTreesJeiPlugin.drawables = Drawables.getDrawables(guiHelper);

		registry.addRecipeCategories(
				new LumbermillRecipeCategory(),
				new FruitPressRecipeCategory(),
				new BreweryRecipeCategory(),
				new DistilleryRecipeCategory()
		);

		registry.addRecipeCategoryCraftingItem(ExtraTreeMachine.Lumbermill.get(1), RecipeUids.LUMBERMILL);
		registry.addRecipeCategoryCraftingItem(ExtraTreeMachine.Press.get(1), RecipeUids.FRUIT_PRESS);
		registry.addRecipeCategoryCraftingItem(ExtraTreeMachine.Brewery.get(1), RecipeUids.BREWING);
		registry.addRecipeCategoryCraftingItem(ExtraTreeMachine.Distillery.get(1), RecipeUids.DISTILLING);

		registry.addRecipes(LumbermillRecipeMaker.create(), RecipeUids.LUMBERMILL);
		registry.addRecipes(FruitPressRecipeMaker.create(), RecipeUids.FRUIT_PRESS);
		registry.addRecipes(BreweryRecipeMaker.create(), RecipeUids.BREWING);
		registry.addRecipes(DistilleryRecipeMaker.create(), RecipeUids.DISTILLING);
	}
}