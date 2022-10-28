package com.varijon.tinies.RareCandyEvoFix.handler;

import java.util.ArrayList;

import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelmonmod.pixelmon.entities.pixelmon.helpers.EvolutionQuery;
import com.pixelmonmod.pixelmon.entities.pixelmon.helpers.EvolutionQueryList;

import net.minecraft.init.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EvolutionHandler 
{
	MinecraftServer server;
	public EvolutionHandler()
	{
		server = FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	@SubscribeEvent(priority=EventPriority.HIGH)
	public void onRareCandyClick (PlayerInteractEvent.EntityInteract event)
	{			
		if(event.getHand() != EnumHand.MAIN_HAND)
		{
			return;
		}
		if(event.getItemStack() == null)
		{
			return;
		}
		if(event.getItemStack().getItem() == Items.AIR)
		{
			return;
		}
		if(event.getItemStack().getItem() == PixelmonItems.rareCandy)
		{
			ArrayList<EvolutionQuery> lstRemove = new ArrayList<EvolutionQuery>();
			for(EvolutionQuery query : EvolutionQueryList.queryList)
			{
				if(query.pokemonUUID.equals(event.getTarget().getUniqueID()))
				{
					lstRemove.add(query);
				}
			}
			for(EvolutionQuery query : lstRemove)
			{
				EvolutionQueryList.queryList.remove(query);
			}
		}
	}
}
