package model;

public class ChannelModel {
    private String channelName;
    private int icon;
    private String url;

    public ChannelModel(){

    }

    public ChannelModel(String channelName, int icon, String url) {
        this.channelName = channelName;
        this.icon = icon;
        this.url = url;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
