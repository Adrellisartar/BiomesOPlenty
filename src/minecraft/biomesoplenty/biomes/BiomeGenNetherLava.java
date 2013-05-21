package biomesoplenty.biomes;

import biomesoplenty.configuration.BOPConfiguration;
import biomesoplenty.worldgen.WorldGenLavaSpring;
import biomesoplenty.worldgen.WorldGenDeadlands;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;

public class BiomeGenNetherLava extends BiomeGenBase
{
	private WorldGenerator theWorldGenerator;
	private BiomeDecoratorBOP customBiomeDecorator;
	
    public BiomeGenNetherLava(int par1)
    {
        super(par1);
		this.theBiomeDecorator = new BiomeDecoratorBOP(this);
        this.customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		this.topBlock = (byte)Block.netherrack.blockID;
        this.fillerBlock = (byte)Block.netherrack.blockID;
		this.customBiomeDecorator.grassPerChunk = 15;
		this.customBiomeDecorator.netherLavaPerChunk = 20;
		this.customBiomeDecorator.generateAsh = true;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 4, 4, 4));
		this.theWorldGenerator = new WorldGenLavaSpring(Block.lavaMoving.blockID, 8);
    }
	
    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        return new WorldGenDeadlands();
    }
	
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);
        int var5 = 100;
        int var6;
        int var7;
        int var8;

        for (var5 = 0; var5 < 5; ++var5)
        {
            var6 = par3 + par2Random.nextInt(16);
            var7 = 64 + par2Random.nextInt(64);
            var8 = par4 + par2Random.nextInt(16);
            this.theWorldGenerator.generate(par1World, par2Random, var6, var7, var8);
        }
    }
}