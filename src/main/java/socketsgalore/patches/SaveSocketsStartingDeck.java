package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import guardian.cards.AbstractGuardianCard;
import socketsgalore.SocketsMod;

@SpirePatch(
	clz=AbstractPlayer.class,
	method="initializeStarterDeck"
)
public class SaveSocketsStartingDeck {
    public static void Postfix(AbstractPlayer player) {
        for (AbstractCard c : player.masterDeck.group)
            if (c.tags.contains(SocketsMod.SOCKETSUPGRADED)) {
                if (((AbstractGuardianCard) c).socketCount > 4)
                    ((AbstractGuardianCard) c).socketCount = 4;
                ((AbstractGuardianCard) c).updateDescription();
                ((AbstractGuardianCard) c).saveGemMisc();
            }
    }
}