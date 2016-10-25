package cofh.thermalexpansion.client.model;

import codechicken.lib.render.block.IExtendedModel;
import cofh.thermalexpansion.client.bakery.BlockBakery;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by covers1624 on 26/10/2016.
 */
public class TFBakedModel implements IBakedModel, IExtendedModel {
    @Override
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand) {
        return new ArrayList<BakedQuad>();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return null;
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return ItemCameraTransforms.DEFAULT;
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new ItemOverrideList(ImmutableList.<ItemOverride>of()){
            @Override
            public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity) {
                return BlockBakery.generateItemModel(stack);
            }
        };
    }

    @Override
    public IBakedModel handleExtendedModel(IBakedModel prevModel, IBlockState state) {
        return BlockBakery.getCachedModel((IExtendedBlockState) state);
    }
}
