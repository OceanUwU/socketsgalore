package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.Soul;
import guardian.cards.AbstractGuardianCard;
import socketsgalore.SocketsMod;

@SpirePatch(
	clz=Soul.class,
	method="obtain"
)
public class SaveSocketsOnAddToDeck {
    public static void Postfix(Soul s, AbstractCard c) {
        if (c.tags.contains(SocketsMod.SOCKETSUPGRADED)) {
            if (((AbstractGuardianCard) c).socketCount > 4)
                ((AbstractGuardianCard) c).socketCount = 4;
            ((AbstractGuardianCard) c).updateDescription();
            ((AbstractGuardianCard) c).saveGemMisc();
        }
    }
}