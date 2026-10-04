package tk.shanebee.adapters.v1_17;

import io.github.rvskele.paperlib.PaperLib;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import tk.shanebee.adapters.legacy.AdapterLegacy;

public class AdapterV1_17 extends AdapterLegacy {
    @Override
    public BlockState getBlockState(Block block) {
        if (PaperLib.isPaper()) return block.getState(false);
        else return block.getState();
    }

    @Override
    public String getWorldId(World world) {
        return world.getName();
    }

    @Override
    public World findWorld(String id) {
        if (id == null) return null;
        World w = Bukkit.getWorld(id);
        if (w == null) {
            int s = id.indexOf('/');
            if (s > 0) w = Bukkit.getWorld(id.substring(s + 1));
        }
        return w;
    }
}
