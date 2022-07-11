package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import guardian.cards.AbstractGuardianCard;
import socketsgalore.SocketsMod;

@SpirePatch(
	clz=CardCrawlGame.class,
	method="loadPlayerSave"
)
public class ReduceSocketsOnSaveLoad {
    public static void Postfix() {
        for (AbstractCard c : AbstractDungeon.player.masterDeck.group)
            if (c.tags.contains(SocketsMod.SOCKETSUPGRADED)) {
                ((AbstractGuardianCard) c).socketCount -= SocketsMod.additionalSockets;
                //if (((AbstractGuardianCard) c).socketCount > 4)
                    //((AbstractGuardianCard) c).socketCount = 4;
                ((AbstractGuardianCard) c).saveGemMisc();
                ((AbstractGuardianCard) c).updateDescription();
            }
    }
}