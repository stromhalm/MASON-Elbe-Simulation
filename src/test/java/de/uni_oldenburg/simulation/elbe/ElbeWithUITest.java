package de.uni_oldenburg.simulation.elbe;

import oracle.jrockit.jfr.JFR;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import sim.display.Controller;
import sim.display.Display2D;
import sim.engine.SimState;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Tests {@link  ElbeWithUI}.
 */
public class ElbeWithUITest {

	private ElbeWithUI elbeWithUI;

	@Before
	public void setUp() {
		elbeWithUI = new ElbeWithUI();
	}

	@Test
	public void loadState() {
		SimState simState = new SimState(0);
		elbeWithUI = new ElbeWithUI(simState);
		assertEquals(elbeWithUI.getSimulationInspectedObject(), simState);
	}

	@Test
	public void getName() {
		assertEquals(elbeWithUI.getName(), "Elbe Simulation");
	}

	@Test
	public void initAndStartAndLoad() {

		elbeWithUI = new ElbeWithUI(mock(Display2D.class), mock(JFrame.class));

		Controller controller = mock(Controller.class);
		SimState simState = new SimState(0);

		elbeWithUI.init(controller);
		elbeWithUI.start();
		elbeWithUI.load(simState);
		assertEquals(elbeWithUI.getSimulationInspectedObject(), simState);
	}

	@Test
	public void quit() {
		elbeWithUI.quit();
	}
}