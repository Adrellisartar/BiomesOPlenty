package biomesoplenty.world;

import net.minecraft.world.WorldProviderHell;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import biomesoplenty.configuration.BOPConfiguration;

public class WorldTypeSize
{
	@ForgeSubscribe
	public void BiomeSize(WorldTypeEvent.BiomeSize event)
	{
	    if (event.worldType.getWorldTypeName() == "BIOMESOP") {
            event.newSize = (byte)BOPConfiguration.biomeSize;
            
            if (BOPConfiguration.netherOverride)
            {
                DimensionManager.unregisterProviderType(-1);
                DimensionManager.registerProviderType(-1, WorldProviderBOPhell.class, true);
            }
        }
        else if (BOPConfiguration.netherOverride && BOPConfiguration.addToDefault)
        {
            DimensionManager.unregisterProviderType(-1);
            DimensionManager.registerProviderType(-1, WorldProviderBOPhell.class, true);
        }
        else
        {
            DimensionManager.unregisterProviderType(-1);
            DimensionManager.registerProviderType(-1, WorldProviderHell.class, true);
        }
	}

}
