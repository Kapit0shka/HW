package horstmann1chapter.normalizationAngle;

// ex. 1.2
public class NormalizationAngle {
    static public int printNormalAngle(int angle) {
        return (angle < 0)? (angle % 360 + 360):(angle % 360);
    }

    static public int printNormalAngleWithFloorMod(int angle){
        return Math.floorMod(angle, 360);
    }
}
