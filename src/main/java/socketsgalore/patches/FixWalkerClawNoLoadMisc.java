package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import guardian.cards.WalkerClaw;

@SpirePatch(
	clz=WalkerClaw.class,
	method=SpirePatch.CONSTRUCTOR
)
public class FixWalkerClawNoLoadMisc {
    public static void Postfix(WalkerClaw c) {
        c.loadGemMisc();
    }
}