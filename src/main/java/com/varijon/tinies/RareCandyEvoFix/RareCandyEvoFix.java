package com.varijon.tinies.RareCandyEvoFix;

import org.apache.logging.log4j.Logger;

import com.varijon.tinies.RareCandyEvoFix.handler.EvolutionHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="rarecandyevofix", version="1.0.0", acceptableRemoteVersions="*")
public class RareCandyEvoFix
{
	public static String MODID = "modid";
	public static String VERSION = "version";
	public static Logger logger;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

		logger = e.getModLog();

	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new EvolutionHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}

	 @EventHandler
	 public void serverLoad(FMLServerStartingEvent event)
	 {

	 }

}