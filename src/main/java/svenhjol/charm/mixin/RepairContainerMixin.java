package svenhjol.charm.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractRepairContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.RepairContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charm.module.AnvilImprovements;
import svenhjol.charm.module.StackableEnchantedBooks;

import java.util.HashMap;
import java.util.Map;

@Mixin(RepairContainer.class)
public abstract class RepairContainerMixin extends AbstractRepairContainer {
    @Shadow @Final private IntReferenceHolder maximumCost;

    @Shadow private String repairedItemName;

    @Shadow private int materialCost;

    public RepairContainerMixin(ContainerType<?> type, int syncId, PlayerInventory playerInventory, IWorldPosCallable context) {
        super(type, syncId, playerInventory, context);
    }

    @Redirect(
        method = "updateRepairOutput",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/entity/player/PlayerAbilities;isCreativeMode:Z",
            ordinal = 1
        )
    )
    private boolean hookUpdateResultTooExpensive(PlayerAbilities abilities) {
        return AnvilImprovements.allowTooExpensive() || abilities.isCreativeMode;
    }

//    @Redirect(
//        method = "updateRepairOutput",
//        at = @At(
//            value = "INVOKE",
//            target = "Lnet/minecraft/enchantment/Enchantment;getMaxLevel()I",
//            ordinal = 1
//        )
//    )
//    private int hookUpdateResultAllowHigherLevel(Enchantment enchantment) {
//        return AnvilImprovements.getEnchantmentMaxLevel(enchantment, this.field_234643_d_.getStackInSlot(1));
//    }


    @Redirect(
        method = "updateRepairOutput",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/enchantment/EnchantmentHelper;setEnchantments(Ljava/util/Map;Lnet/minecraft/item/ItemStack;)V"
        )
    )
    private void hookUpdateResultAllowHigherLevel2(Map<Enchantment, Integer> enchantments, ItemStack stack) {
        ItemStack inputStack = this.field_234643_d_.getStackInSlot(1);

        Map<Enchantment, Integer> reset = new HashMap<>();

        // TODO: check it's an enchanted book

        Map<Enchantment, Integer> bookEnchants = EnchantmentHelper.getEnchantments(inputStack);

        bookEnchants.forEach((e, l) -> {
            if (l > e.getMaxLevel()) {
                reset.put(e, l);
            }
        });

        reset.forEach((e, l) -> {
            if (enchantments.containsKey(e))
                enchantments.put(e, l);
        });

        EnchantmentHelper.setEnchantments(reset, stack);
    }

    @Inject(
        method = "func_230303_b_",
        at = @At("HEAD"),
        cancellable = true
    )
    private void hookCanTakeOutput(PlayerEntity player, boolean unused, CallbackInfoReturnable<Boolean> cir) {
        if (AnvilImprovements.allowTakeWithoutXp(player, maximumCost))
            cir.setReturnValue(true);
    }

    @Redirect(
        method = "func_230301_a_",
        slice = @Slice(
            from = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/item/ItemStack;shrink(I)V"
            )
        ),
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/inventory/IInventory;setInventorySlotContents(ILnet/minecraft/item/ItemStack;)V",
            opcode = Opcodes.INVOKEINTERFACE,
            ordinal = 2
        )
    )
    private void anvilUpdateHook(IInventory inv, int index, ItemStack stack) {
        if (ModuleHandler.enabled(StackableEnchantedBooks.class))
            stack = StackableEnchantedBooks.getReducedStack(inv.getStackInSlot(index));

        inv.setInventorySlotContents(index, stack);
    }
}
