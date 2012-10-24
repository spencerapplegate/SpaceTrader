package edu.gatech.statusquo.spacetrader.presenter;

import java.util.HashMap;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.*;
import edu.gatech.statusquo.spacetrader.model.Good.GoodType;
import edu.gatech.statusquo.spacetrader.view.*;

public class TradeGoodsPresenter {
	Shell shell;
	Driver driver;
	TradeGoodsView tradeGoodsView;
	Player player;
	SolarSystem solarSystem;

	public TradeGoodsPresenter(Shell s, Driver d, TradeGoodsView tgv, Player p, SolarSystem ss) {
		this.shell = s;
		this.driver = d;
		this.tradeGoodsView = tgv;
		this.player = p;
		this.solarSystem = ss;
		
		setListeners();
		fillTradeGoodsTable();
	}
	
	private void setListeners() {
		tradeGoodsView.btnBuy.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				int quant = Integer.parseInt(tradeGoodsView.text.getText());
				if (tradeGoodsView.table_1.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an item from the market");
					return;
				}
				int price = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(1));
				int mQuant = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(3));
			    if(Player.getCurrency() < quant * price)
			    {
					NotificationsView.list_1.add("Sorry, you do not have enough currency to make this purchase");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			    else if(quant > mQuant)
			    {
					NotificationsView.list_1.add("Sorry, there is not enough of this item in the market.");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			}
		});

		// CURRENTLY CODE FOR BUY, WRITE FOR SELL
		tradeGoodsView.btnSell.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				int quant = Integer.parseInt(tradeGoodsView.text.getText());
				if (tradeGoodsView.table_1.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an item from the market");
					return;
				}
				int price = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(1));
				int mQuant = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(3));
			    if(Player.getCurrency() < quant * price)
			    {
					NotificationsView.list_1.add("Sorry, you do not have enough currency to make this purchase");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			    else if(quant > mQuant)
			    {
					NotificationsView.list_1.add("Sorry, there is not enough of this item in the market.");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			}
		});

		tradeGoodsView.text.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseDown(MouseEvent e) {
		    	tradeGoodsView.text.setText("");
		    }
		});

		tradeGoodsView.text_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseDown(MouseEvent e) {
		    	tradeGoodsView.text_1.setText("");
		    }
		});
	}
	
	private void fillTradeGoodsTable() {
		HashMap<GoodType, Integer> marketPrice = solarSystem.getMarketPrice();
		HashMap<GoodType, Integer> marketQuantity = solarSystem.getMarketQuantity();
		String[] water = {"Water", Integer.toString(marketPrice.get(GoodType.WATER)), Integer.toString(marketQuantity.get(GoodType.WATER)), "N/A"};
		tradeGoodsView.waterItem.setText(water);
		String[] fur = {"Fur", Integer.toString(marketPrice.get(GoodType.FUR)), Integer.toString(marketQuantity.get(GoodType.FUR)), "N/A"};
		tradeGoodsView.furItem.setText(fur);
		String[] food = {"Food", Integer.toString(marketPrice.get(GoodType.FOOD)), Integer.toString(marketQuantity.get(GoodType.FOOD)), "N/A"};
		tradeGoodsView.foodItem.setText(food);
		String[] ore = {"Ore", Integer.toString(marketPrice.get(GoodType.ORE)), Integer.toString(marketQuantity.get(GoodType.ORE)), "N/A"};
		tradeGoodsView.oreItem.setText(ore);
		String[] firearms = {"Firearms", Integer.toString(marketPrice.get(GoodType.FIREARM)), Integer.toString(marketQuantity.get(GoodType.FIREARM)), "N/A"};
		tradeGoodsView.firearmsItem.setText(firearms);
		String[] medicine = {"Medicine", Integer.toString(marketPrice.get(GoodType.MEDICINE)), Integer.toString(marketQuantity.get(GoodType.MEDICINE)), "N/A"};
		tradeGoodsView.medicineItem.setText(medicine);
		String[] machines = {"Machines", Integer.toString(marketPrice.get(GoodType.MACHINE)), Integer.toString(marketQuantity.get(GoodType.MACHINE)), "N/A"};
		tradeGoodsView.machinesItem.setText(machines);
		String[] narcotics = {"Narcotics", Integer.toString(marketPrice.get(GoodType.NARCOTIC)), Integer.toString(marketQuantity.get(GoodType.NARCOTIC)), "N/A"};
		tradeGoodsView.narcoticsItem.setText(narcotics);
		String[] robots = {"Robots", Integer.toString(marketPrice.get(GoodType.ROBOT)), Integer.toString(marketQuantity.get(GoodType.ROBOT)), "N/A"};
		tradeGoodsView.robotsItem.setText(robots);
	}
}
