package socketsgalore.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.daily.mods.AbstractDailyMod;
import com.megacrit.cardcrawl.helpers.ModHelper;
import socketsgalore.dailymods.SocketsGalore;

import java.util.HashMap;

@SpirePatch(
    clz = ModHelper.class,
    method = "initialize"
)
public class ModHelperPatch {
    public static void Postfix() {
        HashMap<String, AbstractDailyMod> myMapG = (HashMap) ReflectionHacks.getPrivateStatic(ModHelper.class, "genericMods");
        myMapG.put(SocketsGalore.ID, new SocketsGalore());
        ReflectionHacks.setPrivateStatic(ModHelper.class, "genericMods", myMapG);
    }
}
