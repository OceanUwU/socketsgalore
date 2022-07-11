package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ModHelper;
import guardian.cards.AbstractGuardianCard;
import guardian.GuardianMod;
import socketsgalore.dailymods.SocketsGalore;
import socketsgalore.SocketsMod;

@SpirePatch(
	clz=AbstractGuardianCard.class,
	method="loadGemMisc"
)
public class AddSocketsToCards {
    public static void Postfix(AbstractGuardianCard c) {
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(SocketsGalore.ID) || ModHelper.isModEnabled(SocketsGalore.ID)) {
            if (!c.tags.contains(GuardianMod.GEM) && !c.tags.contains(SocketsMod.SOCKETSUPGRADED)) {
                c.socketCount += SocketsMod.additionalSockets;
                c.tags.add(SocketsMod.SOCKETSUPGRADED);
                c.updateDescription();
            }
        }
    }
}