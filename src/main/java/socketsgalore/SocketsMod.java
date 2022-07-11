package socketsgalore;

import basemod.BaseMod;
import basemod.interfaces.AddCustomModeModsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.RunModStrings;
import com.megacrit.cardcrawl.screens.custom.CustomMod;
import java.util.List;
import socketsgalore.dailymods.SocketsGalore;

@SpireInitializer
public class SocketsMod implements AddCustomModeModsSubscriber, EditStringsSubscriber {
    public static int additionalSockets = 2;
    @SpireEnum
    public static AbstractCard.CardTags SOCKETSUPGRADED;

    public SocketsMod() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new SocketsMod();
    }
    
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(RunModStrings.class, "socketsgaloreResources/localization/eng/RunModStrings.json");
    }
    
    public void receiveCustomModeMods(List<CustomMod> l) {
        l.add(new CustomMod(SocketsGalore.ID, "g", true));
    }
}