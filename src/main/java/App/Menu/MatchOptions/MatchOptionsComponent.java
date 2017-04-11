package App.Menu.MatchOptions;

import App.Game.GameComponent;
import App.Menu.MenuComponent;
import App.Shared.SharedModule;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import App.Shared.JFX.EventReceiver;
import java.awt.*;

/**
 * Created by Hanliang Ding on 09/04/2017.
 */
public class MatchOptionsComponent extends BorderPane implements EventReceiver{
    private MenuComponent menu;
    private SharedModule shared;
    private MediaPlayer buttonSound;
    private int currentButton;

    @FXML
    private CheckBox GhostingBox;

    @FXML
    private CheckBox PowerupsBox;

    @FXML
    private ComboBox timeCombo;

    @FXML
    private RadioButton timeRadio;

    @FXML
    private RadioButton deathRadio;
    
    @FXML
    private RadioButton slowRadio;
    
    @FXML
    private RadioButton mediumRadio;
    
    @FXML
    private RadioButton fastRadio;

    @FXML
    private Text back;

    @FXML
    private Text cont;

    @FXML
    private CheckBox topLeftBox, topRightBox, botLeftBox, botRightBox;

    /**
     * Constructs the Match options component
     */
    private void construct() {
        this.shared.getJFX().loadFXML(this, MatchOptionsComponent.class,
                "MatchOptionsComponent.fxml");

        this.buttonSound = this.shared.getJFX().loadMedia(this.shared.getClass(), "Button.mp3");
        this.buttonSound.setVolume(this.shared.getSettings().soundEffectsVolume);
        
        this.currentButton = 0;
        this.shared.getJFX().getEventReceivers().add(this);

        this.timeCombo.getItems().addAll("2 minutes", "4 minutes", "6 minutes");

        //adds a listener for combo box selection change and detect them
        this.timeCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        	this.playButtonSound();
        	if (this.timeCombo.getSelectionModel().getSelectedItem().toString().equals("3 minutes")) {
        		this.shared.getSettings().maxGameTime = 120;
        	}
        	else if (this.timeCombo.getSelectionModel().getSelectedItem().toString().equals("6 minutes")) {
        		this.shared.getSettings().maxGameTime = 240;
        	}
        	else if (this.timeCombo.getSelectionModel().getSelectedItem().toString().equals("9 minutes")) {
        		this.shared.getSettings().maxGameTime = 360;
        	}
        });
    }

    /**
     * Default Constructor for the title component
     * @param shared
     * @param menu
     */
    public MatchOptionsComponent(SharedModule shared, MenuComponent menu) {
		this.shared = shared;
		this.menu = menu;
		this.construct();
    }

    /**
     * Constructor
     * @param shared access to the JFX scenes and stages
     */
    public MatchOptionsComponent(SharedModule shared) {
        this.shared = shared;
        this.construct();
    }

	/**
	 * plays the button press sound effect
	 */
	public void playButtonSound() {
        this.buttonSound.stop();
        this.buttonSound.setVolume(this.shared.getSettings().soundEffectsVolume);
        this.buttonSound.play();
    }

    /**
     * transition scene back to main
     */
    @FXML
    void onBackClicked() {
    	this.menu.transitionTitle();
		this.playButtonSound();
    }

    /**
     * transition scene to game
     */
    @FXML
    void onContinueClicked() {
    	this.shared.getJFX().setScene("game");
        ((GameComponent) this.shared.getJFX().getScene("game").getKey())
        .startGameCountdown();

		this.playButtonSound();
        this.menu.getMusic().stop();
    }

	/**
	 * sets game mode to death match
	 */
	@FXML
		void onDeathClicked(){
			this.playButtonSound();
    		this.timeCombo.setDisable(true);
    		this.shared.getSettings().scoreWin = false;
    }

	/**
	 * sets game mode to score based, win condition is highest score when game limit ends
	 */
	@FXML
		void onTimeClicked(){
			this.playButtonSound();
    		this.timeCombo.setDisable(false);
    		this.shared.getSettings().scoreWin = true;
    }

	/**
	 * Allows ghosting after a player dies
	 */
	@FXML
		void onGhostClicked(){
    	this.playButtonSound();
    	if (this.GhostingBox.isSelected()) {
    		this.shared.getSettings().ghosting = true;
    	}
    	else {
    		this.shared.getSettings().ghosting = false;
    	}
    }

	/**
	 * Adds powerups
	 */
	@FXML
		void onPowerClicked(){
    	this.playButtonSound();
    	if (this.PowerupsBox.isSelected()) {
    		this.shared.getSettings().powerups = true;
    	}
    	else {
    		this.shared.getSettings().powerups = false;
    	}
    }

	/**
	 * top left is AI or human
	 */
	@FXML
		void onTopLeftClicked(){
    	this.playButtonSound();
    	if (this.topLeftBox.isSelected()) {
    		this.shared.getSettings().topLeft = 1;
    	}
    	else {
    		this.shared.getSettings().topLeft = 1;
    	}
    }

	/**
	 * top right is AI or human
	 */
	@FXML
		void onTopRightClicked(){
    	this.playButtonSound();
    	if (this.topRightBox.isSelected()) {
    		this.shared.getSettings().topRight = 1;
    	}
    	else {
    		this.shared.getSettings().topRight = 1;
    	}
    }

	/**
	 * bottom left AI or human player
	 */
	@FXML
		void onBotLeftClicked(){
    	this.playButtonSound();
    	if (this.botLeftBox.isSelected()) {
    		this.shared.getSettings().botLeft = 1;
    	}
    	else {
    		this.shared.getSettings().botLeft = 1;
    	}
    }

	/**
	 * bottom right AI or human player
	 */
	@FXML
		void onBotRightClicked(){
    	this.playButtonSound();
    	if (this.botRightBox.isSelected()) {
    		this.shared.getSettings().botRight = 1;
    	}
    	else {
    		this.shared.getSettings().botRight = 1;
    	}
    }

	/**
	 * sets ball speed to slow
	 */
	@FXML
		void onSlowClicked(){
			this.playButtonSound();
    		this.shared.getSettings().ballSpeed = 100;
    }

	/**
	 * sets ball speed to medium
	 */
	@FXML
		void onMediumClicked(){
			this.playButtonSound();
			this.shared.getSettings().ballSpeed = 200;
    }

	/**
	 * sets ball speed to fast
	 */
	@FXML
		void onFastClicked(){
    		this.playButtonSound();
			this.shared.getSettings().ballSpeed = 300;
    }
	
    @Override
    public void onKeyEvent(KeyEvent event){
    	
    	if (event.getEventType() == KeyEvent.KEY_RELEASED) {
    		if (event.getCode() == KeyCode.TAB) {
    			if (currentButton < 11) {
    				currentButton++;
    			}
    			else if (currentButton == 11) {
    				currentButton = 0;
    			}
    		}

    		else if (event.getCode() == KeyCode.ENTER) {
    			switch (currentButton) {
    			case 0:	this.GhostingBox.fire();
        				this.playButtonSound();
    			break;

    			case 1: this.PowerupsBox.fire();
						this.playButtonSound();
    			break;

    			case 2: this.slowRadio.setSelected(true);
						this.playButtonSound();
    			break;
    			
    			case 3: this.mediumRadio.setSelected(true);
						this.playButtonSound();
				break;
		
    			case 4: this.fastRadio.setSelected(true);
    					this.playButtonSound();
				break;
		
    			case 5: this.playButtonSound();
						this.shared.getJFX().closeStage();
				break;

    			case 6: this.playButtonSound();
				this.shared.getJFX().closeStage();
				break;
		
    			case 7: this.playButtonSound();
				this.shared.getJFX().closeStage();
				break;
		
    			case 8: this.playButtonSound();
				this.shared.getJFX().closeStage();
				break;
		
    			case 9: this.playButtonSound();
				this.shared.getJFX().closeStage();
				break;
		
    			case 10: this.playButtonSound();
				this.shared.getJFX().closeStage();
				break;
		
    			case 11: this.playButtonSound();
				this.shared.getJFX().closeStage();
				break;
    			}
    		}
    	}
    }

}
