package net.bukkit_plugin.kojima1021.BarLeaveMessage;

import net.bukkit_plugin.kojima1021.BarLeaveMessage.event.LeaveEvent;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * BarJoinMessage メインクラス
 * @author kojima1021
 */
public class Main extends JavaPlugin implements Listener{
    //インスタンス
    private static Main instance;
    /**
     * メインクラスを取得します
     * @return instance
     */
    public static Main getInstance(){
        return instance;
    }
    //Plugin開始時
    @Override
    public void onEnable() {
        //初期設定完了;
        //リスナー登録
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(
        		new LeaveEvent(), this);
        //インスタンス設定
        instance = this;
        //BarApi確認
        if (getServer().getPluginManager().isPluginEnabled("BarAPI")) {
            getLogger().info("Ver.1.0.0");
          }
          else {
            getLogger().info("BarAPIが正常に読み込まれませんでした。");
            getLogger().info("申し訳ございませんが、プラグインを入れなおすか、プラグインをいれてください");
            getLogger().info("http://dev.bukkit.org/bukkit-plugins/bar-api/");
            getLogger().info("Pluginを停止します。");
            getServer().getPluginManager().disablePlugins();
          }
    }
    //Pluginun終了時
    @Override
    public void onDisable() {
    	if (getServer().getPluginManager().isPluginEnabled("BarAPI")) {
            getLogger().info("プラグインを正常に終了しました");
          }
          else {
          }
    }
}