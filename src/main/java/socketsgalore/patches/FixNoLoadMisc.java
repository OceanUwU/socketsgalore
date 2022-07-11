package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import guardian.cards.AbstractGuardianCard;
import java.util.ArrayList;
import java.util.Arrays;

@SpirePatch(
	clz=AbstractGuardianCard.class,
	method=SpirePatch.CONSTRUCTOR
)
public class FixNoLoadMisc {
    public static ArrayList<String> cardsToFix = new ArrayList<>(Arrays.asList(
        "Guardian:DecasProtection",
        "Guardian:DonusPower",
        "Guardian:TimeSifter"
    ));

    public static void Postfix(AbstractGuardianCard c) {
        if (cardsToFix.contains(c.cardID))
            c.loadGemMisc();
    }
}