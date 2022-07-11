package socketsgalore.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import guardian.cards.AbstractGuardianCard;
import java.util.ArrayList;
import java.util.Arrays;

@SpirePatch(
	clz=AbstractGuardianCard.class,
	method="use"
)
public class AlwaysUseGems {
    public static ArrayList<String> cardsToFix = new ArrayList<>(Arrays.asList(
        "Guardian:AncientConstruct",
        "Guardian:ArmoredProtocol",
        "Guardian:BodySlam",
        "Guardian:BronzeArmor",
        "Guardian:CompilePackage",
        "Guardian:ConstructionForm",
        "Guardian:CrystalBeam",
        "Guardian:CrystalShiv",
        "Guardian:CrystalWard",
        "Guardian:CurlUp",
        "Guardian:DecasProtection",
        "Guardian:Defend_Guardian",
        "Guardian:DonusPower",
        "Guardian:EvasiveProtocol",
        "Guardian:FastForward",
        "Guardian:FloatingOrbs",
        "Guardian:FuturePlans",
        "Guardian:GatlingBeam",
        "Guardian:GemFinder",
        "Guardian:GemFire",
        "Guardian:MassSlam",
        "Guardian:MassTimeBomb",
        "Guardian:ModeShift",
        "Guardian:OrbSlam",
        "Guardian:Orbwalk",
        "Guardian:RefractedBeam",
        "Guardian:Repulse",
        "Guardian:RevengeProtocol",
        "Guardian:ShieldCharger",
        "Guardian:ShieldSpikes",
        "Guardian:SphericShield",
        "Guardian:SpikerProtocol",
        "Guardian:StasisEngine",
        "Guardian:TimeBomb",
        "Guardian:TimeCapacitor",
        "Guardian:TimeSifter",
        "Guardian:WalkerClaw"
    ));

    public static void Postfix(AbstractGuardianCard c, AbstractPlayer p, AbstractMonster m) {
        if (cardsToFix.contains(c.cardID))
            c.useGems(p, m);
    }
}