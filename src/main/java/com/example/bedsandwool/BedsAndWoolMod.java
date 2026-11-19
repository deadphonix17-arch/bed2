package com.example.bedsandwool;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.block.BedBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.BlockItem;

public class BedsAndWoolMod implements ModInitializer {
    public static final String MOD_ID = "bedsandwool";

    /** Max stack size for every bed (all 16 colors). */
    public static final int BED_STACK_SIZE = 16;

    /** A sheared sheep regrows its wool every this many ticks (20 ticks = 1 second). */
    public static final int WOOL_REGROW_INTERVAL_TICKS = 100;

    @Override
    public void onInitialize() {
        // Override the default max stack size component of every bed item.
        DefaultItemComponentEvents.MODIFY.register(context ->
            context.modify(
                item -> item instanceof BlockItem blockItem && blockItem.getBlock() instanceof BedBlock,
                (builder, item) -> builder.add(DataComponentTypes.MAX_STACK_SIZE, BED_STACK_SIZE)
            )
        );
    }
}
