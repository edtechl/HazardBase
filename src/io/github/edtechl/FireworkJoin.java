package io.github.edtechl;
 
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Firework;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
 
public class FireworkJoin implements Listener {
	
	public Main main;
	
	public FireworkJoin(Main instance){
		main = instance;
	}
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent pje) {
    			
    			Firework f = (Firework) pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);
    			
    			FireworkMeta fm = f.getFireworkMeta();
    			fm.addEffect(FireworkEffect.builder()
    					.flicker(false)
    					.trail(true)
    					.with(Type.BALL)
    					.with(Type.BALL_LARGE)
    					.with(Type.STAR)
    					.withColor(Color.ORANGE)
    					.withColor(Color.YELLOW)
    					.withFade(Color.PURPLE)
    					.withFade(Color.RED)
    					.build());
    			fm.setPower(2);
    			f.setFireworkMeta(fm);
    }
}