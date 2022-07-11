package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import guardian.cards.AbstractGuardianCard;
import guardian.rewards.GemRewardAllRarities;
import socketsgalore.dailymods.SocketsGalore;

@SpirePatch(
	clz=AbstractRoom.class,
	method="endBattle"
)
public class AddGemReward {
    public static void Postfix(AbstractRoom __instance) {
        System.out.println(ModHelper.isModEnabled(SocketsGalore.ID));
        System.out.println(CardCrawlGame.trial != null);
        if (CardCrawlGame.trial != null)
            System.out.println(CardCrawlGame.trial.dailyModIDs());
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(SocketsGalore.ID) || ModHelper.isModEnabled(SocketsGalore.ID)) {
            __instance.rewards.add(new GemRewardAllRarities());
        }
    }
}