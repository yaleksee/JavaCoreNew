package src.less12.io.game;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Сериализация — это процесс сохранения состояния объекта в последовательность байт.
 *
 * Десериализация — это процесс восстановления объекта из этих байт.
 */

public class SaveGame implements Serializable {

    transient private String[] territoriesInfo;
    private String[] resourcesInfo;
    private String[] diplomaticInfo;

    public SaveGame(String[] territoriesInfo, String[] resourcesInfo, String[] diplomaticInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomaticInfo = diplomaticInfo;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(String[] resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public String[] getDiplomaticInfo() {
        return diplomaticInfo;
    }

    public void setDiplomaticInfo(String[] diplomaticInfo) {
        this.diplomaticInfo = diplomaticInfo;
    }

    @Override
    public String toString() {
        return "SaveGame{" +
                "territoriesInfo=" + Arrays.toString(territoriesInfo) +
                ", resourcesInfo=" + Arrays.toString(resourcesInfo) +
                ", diplomaticInfo=" + Arrays.toString(diplomaticInfo) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaveGame)) return false;
        SaveGame saveGame = (SaveGame) o;
        return Arrays.equals(getTerritoriesInfo(), saveGame.getTerritoriesInfo()) &&
                Arrays.equals(getResourcesInfo(), saveGame.getResourcesInfo()) &&
                Arrays.equals(getDiplomaticInfo(), saveGame.getDiplomaticInfo());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getTerritoriesInfo());
        result = 31 * result + Arrays.hashCode(getResourcesInfo());
        result = 31 * result + Arrays.hashCode(getDiplomaticInfo());
        return result;
    }
}
