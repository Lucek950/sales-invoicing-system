package controllers.businessControllers;

import controllers.Controller;
import controllers.mainControllers.MainController;
import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelFx.entitiesFX.businessFX.BusinessModel;
import utils.DialogUtils;
import utils.UtilsProject;
import utils.exceptions.ApplicationException;
import utils.fxmlFieldUtils.ChangeListener;

import java.util.Optional;

public class AddBusinessController implements Controller {

    @FXML
    private Label correctLabel;
    @FXML
    private Button saveBtn;

    @FXML
    private Label wrongName;
    @FXML
    private Label wrongNip;
    @FXML
    private Label wrongTown;
    @FXML
    private Label wrongNumber;
    @FXML
    private Label wrongCountry;
    @FXML
    private Label wrongTownPost;
    @FXML
    private Label wrongNumberPost;
    @FXML
    private Label wrongCountryPost;
    @FXML
    private Label wrongPhone;
    @FXML
    private Label wrongFax;
    @FXML
    private Label wrongZipCode2;
    @FXML
    private Label wrongZipCode1;
    @FXML
    private Label wrongZipCodePost1;
    @FXML
    private Label wrongZipCodePost2;
    @FXML
    private Label wrongBank1;
    @FXML
    private Label wrongBank2;
    @FXML
    private Label wrongBank3;
    @FXML
    private Label wrongBank4;
    @FXML
    private Label wrongBank5;
    @FXML
    private Label wrongBank6;
    @FXML
    private Label wrongBank7;
    @FXML
    private Label wrongBank;

    @FXML
    private TextField name;
    @FXML
    private TextField nip;
    @FXML
    private TextField town;
    @FXML
    private TextField zc1;
    @FXML
    private TextField zc2;
    @FXML
    private TextField street;
    @FXML
    private TextField number;
    @FXML
    private TextField country;
    @FXML
    private TextField townPost;
    @FXML
    private TextField zc1Post;
    @FXML
    private TextField zc2Post;
    @FXML
    private TextField streetPost;
    @FXML
    private TextField numberPost;
    @FXML
    private TextField countryPost;
    @FXML
    private TextField phone;
    @FXML
    private TextField fax;
    @FXML
    private TextField email;
    @FXML
    private TextField website;
    @FXML
    private TextField bank1;
    @FXML
    private TextField bank2;
    @FXML
    private TextField bank3;
    @FXML
    private TextField bank4;
    @FXML
    private TextField bank5;
    @FXML
    private TextField bank6;
    @FXML
    private TextField bank7;

    @FXML
    private CheckBox checkAddress;

    private final BooleanProperty sameAddress = new SimpleBooleanProperty(false);

    private BusinessModel businessModel;

    @FXML
    private void initialize() {
        businessModel = new BusinessModel();
        try {
            businessModel.init();
        } catch (ApplicationException e) {
            DialogUtils.errorDialog(e.getMessage());
        }
        selectAllContentsFromTF();
        validation();
        saveButtonActivate();
        bindings();
        onSetSameAddress();
    }

    private void selectAllContentsFromTF(){
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(name);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(nip);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(town);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(zc1);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(zc2);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(street);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(number);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(country);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(townPost);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(streetPost);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(zc1Post);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(zc2Post);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(numberPost);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(countryPost);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(phone);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(fax);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(email);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(website);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank1);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank2);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank3);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank4);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank5);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank6);
        UtilsProject.selectAllInTextFieldWhenClickOnMouse(bank7);
    }

    private void validation(){
        name.textProperty().addListener(new ChangeListener(name,80, wrongName));
        nip.textProperty().addListener(new ChangeListener(nip, 10, 10, wrongNip));
        town.textProperty().addListener(new ChangeListener(town, 80, wrongTown));
        zc1.textProperty().addListener(new ChangeListener(zc1, 2, 2, wrongZipCode1));
        zc2.textProperty().addListener(new ChangeListener(zc2, 3, 3, wrongZipCode2));
        street.textProperty().addListener(new ChangeListener(street, 40, ChangeListener.WITHOUT_WRONG_LABEL));
        number.textProperty().addListener(new ChangeListener(number, 9, wrongNumber));
        country.textProperty().addListener(new ChangeListener(country, 80, wrongCountry));
        townPost.textProperty().addListener(new ChangeListener(townPost, 80, wrongTownPost, sameAddress));
        streetPost.textProperty().addListener(new ChangeListener(streetPost, 40, ChangeListener.WITHOUT_WRONG_LABEL, sameAddress));
        zc1Post.textProperty().addListener(new ChangeListener(zc1Post, 2, 2, wrongZipCodePost1, sameAddress));
        zc2Post.textProperty().addListener(new ChangeListener(zc2Post, 3, 3, wrongZipCodePost2, sameAddress));
        numberPost.textProperty().addListener(new ChangeListener(numberPost, 9, wrongNumberPost, sameAddress));
        countryPost.textProperty().addListener(new ChangeListener(countryPost, 80, wrongCountryPost, sameAddress));
        phone.textProperty().addListener(new ChangeListener(phone, 9, 12, wrongPhone));
        fax.textProperty().addListener(new ChangeListener(fax, 9, 12, wrongFax, ChangeListener.FIELDS_WHO_CAN_BE_NULL));
        email.textProperty().addListener(new ChangeListener(email, 80, ChangeListener.WITHOUT_WRONG_LABEL));
        website.textProperty().addListener(new ChangeListener(website, 80, ChangeListener.WITHOUT_WRONG_LABEL));
        bank1.textProperty().addListener(new ChangeListener(bank1, 2, 2, wrongBank1));
        bank2.textProperty().addListener(new ChangeListener(bank2, 4, 4, wrongBank2));
        bank3.textProperty().addListener(new ChangeListener(bank3, 4, 4, wrongBank3));
        bank4.textProperty().addListener(new ChangeListener(bank4, 4, 4, wrongBank4));
        bank5.textProperty().addListener(new ChangeListener(bank5, 4, 4, wrongBank5));
        bank6.textProperty().addListener(new ChangeListener(bank6, 4, 4, wrongBank6));
        bank7.textProperty().addListener(new ChangeListener(bank7, 4, 4, wrongBank7));
    }

    private void saveButtonActivate(){
        wrongBank.visibleProperty().bind(new When(bank1.textProperty().isEmpty().and(bank2.textProperty().isEmpty()).and(bank3.textProperty().isEmpty())
                .and(bank4.textProperty().isEmpty()).and(bank5.textProperty().isEmpty()).and(bank6.textProperty().isEmpty()).and(bank7.textProperty().isEmpty()))
                .then(true).otherwise(wrongBank1.visibleProperty()
                        .or(wrongBank2.visibleProperty())
                        .or(wrongBank3.visibleProperty())
                        .or(wrongBank4.visibleProperty())
                        .or(wrongBank5.visibleProperty())
                        .or(wrongBank6.visibleProperty())
                        .or(wrongBank7.visibleProperty())));

        correctLabel.visibleProperty()
                .bind(wrongName.visibleProperty()
                        .or(wrongTown.visibleProperty())
                        .or(wrongNip.visibleProperty())
                        .or(wrongZipCode1.visibleProperty())
                        .or(wrongZipCode2.visibleProperty())
                        .or(wrongNumber.visibleProperty())
                        .or(wrongCountry.visibleProperty())
                        .or(wrongTownPost.visibleProperty())
                        .or(wrongZipCodePost1.visibleProperty())
                        .or(wrongZipCodePost2.visibleProperty())
                        .or(wrongNumberPost.visibleProperty())
                        .or(wrongCountryPost.visibleProperty())
                        .or(wrongPhone.visibleProperty())
                        .or(wrongFax.visibleProperty())
                        .or(wrongBank.visibleProperty()));

        saveBtn.disableProperty().bind(correctLabel.visibleProperty());
    }

    private void bindings(){
        name.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().nameProperty());
        nip.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().nipProperty());
        town.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().townProperty());
        zc1.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().zc1Property());
        zc2.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().zc2Property());
        street.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().streetProperty());
        number.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().addressProperty());
        country.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().countryProperty());
        checkAddress.selectedProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().postSameProperty());
        townPost.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().townPostProperty());
        zc1Post.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().zc1PostProperty());
        zc2Post.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().zc2PostProperty());
        streetPost.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().streetPostProperty());
        numberPost.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().addressPostProperty());
        countryPost.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().countryPostProperty());
        phone.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().phoneProperty());
        fax.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().faxProperty());
        email.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().emailProperty());
        website.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().websiteProperty());
        bank1.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank1Property());
        bank2.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank2Property());
        bank3.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank3Property());
        bank4.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank4Property());
        bank5.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank5Property());
        bank6.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank6Property());
        bank7.textProperty().bindBidirectional(businessModel.getBusinessFXObjectProperty().bank7Property());
    }

    private void clearPostFields(){
        townPost.clear();
        zc1Post.clear();
        zc2Post.clear();
        streetPost.clear();
        numberPost.clear();
        countryPost.clear();
    }

    @FXML
    private void onSetSameAddress() {
         if (checkAddress.selectedProperty().getValue().equals(true)) {
             sameAddress.set(true);
             townPost.textProperty().bind(town.textProperty());
             zc1Post.textProperty().bind(zc1.textProperty());
             zc2Post.textProperty().bind(zc2.textProperty());
             streetPost.textProperty().bind(street.textProperty());
             numberPost.textProperty().bind(number.textProperty());
             countryPost.textProperty().bind(country.textProperty());
        } else {
             sameAddress.set(false);
             townPost.textProperty().unbind();
             zc1Post.textProperty().unbind();
             zc2Post.textProperty().unbind();
             streetPost.textProperty().unbind();
             numberPost.textProperty().unbind();
             countryPost.textProperty().unbind();
             clearPostFields();
        }
    }

    @FXML
    private void onClearAllFields() {
        name.clear();
        nip.clear();
        town.clear();
        zc1.clear();
        zc2.clear();
        street.clear();
        number.clear();
        country.clear();
        clearPostFields();
        phone.clear();
        fax.clear();
        email.clear();
        website.clear();
        bank1.clear();
        bank2.clear();
        bank3.clear();
        bank4.clear();
        bank5.clear();
        bank6.clear();
        bank7.clear();
    }

    private static InfoBusinessController infoBusinessController;
    protected static void setInfoBusinessController(InfoBusinessController infoBusinessController) {
        AddBusinessController.infoBusinessController = infoBusinessController;
    }

    private static MainController mainController;
    public static void setMainController(MainController mainController) {
        AddBusinessController.mainController = mainController;
    }

    @FXML
    private void onSave() {
        Optional<ButtonType> result = DialogUtils.confirmDialog();
        if(result.isPresent()) {
            try {
                businessModel.saveBusinessInDataBase();
            } catch (ApplicationException e) {
                DialogUtils.errorDialog(e.getMessage());
            }
            infoBusinessController.initialize();
            mainController.initialize();
            if(MainController.getStage() != null)
                MainController.getStage().close();
            else
                InfoBusinessController.getStage().close();
        }
    }

    @FXML
    private void onCancel() {
        if(MainController.getStage() != null)
            MainController.getStage().close();
        else
            InfoBusinessController.getStage().close();
    }
}
