import java.awt.Color;
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


public class GigaApp extends AbstractMultimediaApp {

	
	public GigaApp(){
		super();
	}
	
	public void init()
	{	      
		ContentFactory						factory;
		Bernstein							sprite;
		Background							bg;
		int									height, width;
		JPanel								contentPane;
		ResourceFinder						finder;
		Stage								stage;
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

		System.out.println(width);
		System.out.println(height);
		
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
		for (int jj = 0 ; jj < actions.size() ;jj++){
			JButton	btn;
			btn = new JButton(actions.get(jj).description());
			buttons.add(btn);
			
		}

		for (int jj= 0 ; jj < buttons.size() ; jj++){
			buttonWidth = 600/buttons.size();
			JButton btn;
			System.out.println("In HERE");
			btn = buttons.get(jj);
			btn.setBounds(buttonStartX,buttonStartY,(int)Math.floor(buttonWidth),50);
			contentPane.add(btn);
		}
		
		contentPane.add(stageView);
		
		
		// Start the dynamics
		stage.start();
	}
}
