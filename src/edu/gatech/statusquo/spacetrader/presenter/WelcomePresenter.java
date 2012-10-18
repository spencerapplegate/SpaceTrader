package edu.gatech.statusquo.spacetrader.presenter;

import edu.gatech.statusquo.spacetrader.view.*;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class WelcomePresenter {
	private WelcomeView wv;
	
	public WelcomePresenter(WelcomeView wv) {
		this.wv = wv;
		
		setListeners();
		
		while (!wv.shell.isDisposed()) {
		if (!wv.display.readAndDispatch()) {
			wv.display.sleep();
		}
	}
	}
	
	private void setListeners() {
		wv.btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt
			 * .events.MouseEvent) So this is where the mousedown event happens.
			 * Notice I set the visibility of all the parts of the first window
			 * to false, and then I ran the method that would create the
			 * CharacterCreationScreen in the same shell. -Shawn
			 */
			public void mouseDown(MouseEvent e) {
//				wv.btnStartGame.setVisible(false);
//				wv.btnLoadGame.setVisible(false);
//				wv.lblWelcomeToSpace.setVisible(false);
				// need to return to driver to signify need to create next view
				//createCharacterCreationScreen();
				wv.shell.dispose();
			}
		});
	}
}
