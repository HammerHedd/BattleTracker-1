package mc.alk.tracker;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import mc.alk.tracker.objects.PlayerStat;
import mc.alk.tracker.objects.Stat;
import mc.alk.tracker.objects.StatType;
import mc.alk.tracker.objects.TeamStat;
import mc.alk.tracker.objects.WLT;
import mc.alk.tracker.objects.WLTRecord;
import mc.alk.tracker.ranking.RankingCalculator;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public interface TrackerInterface{
		
	public void printTopX(CommandSender sender, StatType statType, int x, int teamSize);
	public void printTopX(CommandSender sender, StatType statType, int x, int teamSize, String headerMsg, String bodyMsg);
	
	public void addStatRecord(Stat team1, Stat team2, WLT wlt,boolean saveIndividualRecord);

	public void addPlayerRecord(String p1, String p2, WLT wlt);	
	public void addPlayerRecord(String p1, String p2, WLT wlt, boolean saveIndividualRecord);
	public void addPlayerRecord(OfflinePlayer p1, OfflinePlayer p2, WLT wlt);
	
	public void addTeamRecord(String t1, String t2, WLT wlt);
	public void addTeamRecord(Set<String> team1, Set<String> team2, WLT wlt);
	public void addTeamRecord(Collection<Player> team1, Collection<Player> team2, WLT wlt);


	public PlayerStat getPlayerRecord(String player) ;
	public PlayerStat getPlayerRecord(OfflinePlayer player) ;

	public TeamStat getTeamRecord(String teamName);
	public TeamStat getTeamRecord(Set<String> players);

	/**
	 * Stop tracking stats and don't display kill messages for this player
	 * @param playerName
	 */
	public void stopTracking(String playerName);
	
	/**
	 * Resume tracking stats and resume kill messages for this player
	 * @param playerName
	 */
	public void resumeTracking(String playerName);
	
	/**
	 * Stop displaying kill messages for this player
	 * @param playerName
	 */
	public void stopMessages(String playerName);
	/**
	 * Resume displaying kill messages for this player
	 * @param playerName
	 */
	public void resumeMessages(String playerName);

	/**
	 * Stop tracking stats and don't display kill messages for this player
	 * @param player
	 */
	public void stopTracking(OfflinePlayer player);
	/**
	 * Resume tracking stats and resume kill messages for this player
	 * @param player
	 */
	public void resumeTracking(OfflinePlayer player);
	/**
	 * Stop displaying kill messages for this player
	 * @param player
	 */
	public void stopMessages(OfflinePlayer player);
	/**
	 * Resume displaying kill messages for this player
	 * @param player
	 */
	public void resumeMessages(OfflinePlayer player);

	public void resumeMessages(Collection<Player> players);
	public void resumeTracking(Collection<Player> players);
	public void stopMessages(Collection<Player> players);
	public void stopTracking(Collection<Player> players);

	public void addRecordGroup(Collection<Player> team1, Collection<Collection<Player>> teams, WLT wlt);

	public Stat getRecord(String player);

	public Stat getRecord(OfflinePlayer player);
	public Stat loadRecord(OfflinePlayer op);
	public Stat loadPlayerRecord(String name);
	public Stat loadRecord(Set<Player> players);

	public Stat getRecord(Collection<Player> players);
	
	public void saveAll();

	public List<Stat> getTopX(StatType statType, int x);
	public List<Stat> getTopXRanking(int x);
	public List<Stat> getTopXLosses(int x);
	public List<Stat> getTopXWins(int x);
	public List<Stat> getTopXKDRatio(int x);

	public List<Stat> getTopX(StatType statType, int x, int teamSize);
	public List<Stat> getTopXRanking(int x, int teamSize);
	public List<Stat> getTopXLosses(int x, int teamSize);
	public List<Stat> getTopXWins(int x, int teamSize);
	public List<Stat> getTopXKDRatio(int x, int teamSize);

	public void resetStats();

	public void onlyTrackOverallStats(boolean b);

	/**
	 * Get the ranking calculator being used(default EloCalculator)
	 * @return
	 */
	public RankingCalculator getRankingCalculator();

	/**
	 * Set the ranking of the given player
	 * @param player
	 * @param ranking
	 * @return
	 */
	public boolean setRanking(OfflinePlayer player, int elo);
	

	/**
	 * Get the records of player1 vs player2
	 * @param playerName 
	 * @param playerName2
	 * @param x : the number of records to return, -1 for all
	 * @return
	 */
	public List<WLTRecord> getVersusRecords(String playerName, String playerName2, int x);


	/** 
	 * What is the name of this interface
	 * @return
	 */
	public String getInterfaceName();

	/**
	 * Immediately save these stats (they usually get saved at an appropriate time)
	 * @param stats
	 */
	public void save(Stat... stats);

	/**
	 * Immediately save all records (they usually get saved at an appropriate time)
	 * and empty the cache
	 * @param stats
	 */
	public void flush();
}