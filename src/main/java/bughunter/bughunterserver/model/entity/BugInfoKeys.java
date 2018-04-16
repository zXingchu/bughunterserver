package bughunter.bughunterserver.model.entity;

import java.io.Serializable;

public class BugInfoKeys implements Serializable {

    private Integer appId;

    private Integer bugId;

    public BugInfoKeys(){}

    public BugInfoKeys(Integer appId, Integer bugId) {
        this.appId = appId;
        this.bugId = bugId;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((appId == null) ? 0 : appId.hashCode());
        result = PRIME * result + ((bugId == null) ? 0 : bugId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final BugInfoKeys other = (BugInfoKeys) obj;
        if (appId == null) {
            if (other.appId != null) {
                return false;
            }
        } else if (!appId.equals(other.appId)) {
            return false;
        }
        if (bugId == null) {
            if (other.bugId != null) {
                return false;
            }
        } else if (!bugId.equals(other.bugId)) {
            return false;
        }

        return true;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }
}
