import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import visual.Visualization;
import visual.VisualizationView;
import visual.dynamic.described.Sprite;
import visual.dynamic.described.Stage;
import visual.dynamic.sampled.Screen;
import visual.dynamic.sampled.TransformableContentSuperimposition;
import visual.statik.TransformableContent;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

import io.ResourceFinder;
import app.AbstractMultimediaApp;


public class GigaApp extends AbstractMultimediaApp implements ActionListener{
	
	private Stage								stage;
	private Bernstein							sprite;
	private Background							bg;
	
	public GigaApp(){
		super();
	}

	
	public void actionPerformed(ActionEvent event)
    {
       sprite.handleAction(event);
    }

	
	
	public void init()
	{	      
		ContentFactory						factory;
		
		int									height, width;
		JPanel								contentPane;
		ResourceFinder						finder;
		
		TransformableContent				content;
		VisualizationView					stageView;
		width = 600;
		height = 400;
		ArrayList<Action>					actions;
		finder = ResourceFinder.createInstance(this);
		ArrayList<JButton>					buttons;
		int buttonStartX, buttonStartY;
		double buttonWidth;
		buttonStartX = 0;
		buttonStartY = 350;
		
		buttons = new ArrayList<JButton>();
		factory = new ContentFactory(finder);
		
		// The Stage
		stage = new Stage(50);
		contentPane = (JPanel)rootPaneContainer.getContentPane();


		
		// The Sprite
		bg = new Background();
		content = factory.createContent(bg.getImage(),3, false);
		bg = new Background(content, width, height);
		stage.add(content);
		
		stageView = stage.getView();
		stageView.setBounds(0,0,width,height);
		
		sprite = new Bernstein();
		content = factory.createContent(sprite.getImage(), 4, false);
		sprite = new Bernstein(stage, content, width, height);
		
		
		sprite.setActions();
		actions = sprite.getActions();
		
		// The content pane
		JButton	btn;
		String desc;
		Action action;
		for (int jj = 0 ; jj < actions.size() ;jj++){
			action = actions.get(jj);
			btn = new JButton(action.description());
			buttons.add(btn);
		}
		
		buttonWidth = 600/buttons.size();
		for (int jj= 0 ; jj < buttons.size() ; jj++){
			btn = buttons.get(jj);
			btn.setBounds(buttonStartX,buttonStartY,(int)Math.floor(buttonWidth),50);
			buttonStartX+=buttonWidth;
			btn.addActionListener(this);
			contentPane.add(btn);
		}
		
		contentPane.add(stageView);
		
		
		// Start the dynamics
		stage.start();
	}
}
