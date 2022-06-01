package elit;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ee {
    @Test
    public void davaleba() {

        Selenide.open("https://ee.ge/");
        $("#search_list").setValue("გაზის გამათბობელი").pressEnter();
        int namber = $$("add_to_cart").size();
        for (int i = 0; i < namber; i++) {
            String codi = $("sm-center", i).$(Selectors.byTagName("p"), 1).getText();
            $("add_to_cart", i).click();
            $("react-toast-notifications__toast__content").shouldBe(Condition.visible, Duration.ofMillis(6000));
            Assert.assertEquals(codi + " დამატებულია კალათაში", $("react-toast-notifications__toast__content").getText());
            sleep(3000);
        }

    }

    @Test
    public void davaleba2() {
        Selenide.open("https://ee.ge/");
        $(".btn-register").click();
        $("#firstName").setValue("givi");
        Assert.assertFalse($("#firstName").is(Condition.empty));
        $("#lastName").setValue("chichikoshvili");
        Assert.assertFalse($("#lastName").is(Condition.empty));
        $("#email").setValue("givichichikoshvili09@gmail.com");
        Assert.assertFalse($("#email").is(Condition.empty));
        $("#password").setValue("123456");
        Assert.assertFalse($("#password").is(Condition.empty));
        $("#confirmPassword").setValue("123456");
        Assert.assertFalse($("#confirmPassword").is(Condition.empty));

        sleep(5000);
    }

    @Test
    public void davaleba3() {
        Selenide.open("https://ee.ge/");
        $(".btn-register").click();
        $("#firstName").click();
        $("#lastName").click();
        Assert.assertEquals("სახელი სავალდებულოა", $(Selectors.byText("სახელი სავალდებულოა")).getText());
        $("#lastName").click();
        $("#email").click();
        Assert.assertEquals("გვარი სავალდებულოა", $(Selectors.byText("გვარი სავალდებულოა")).getText());
        $("#email").click();
        $(".form-control").click();
        Assert.assertEquals("ელ. ფოსტა სავალდებულოა", $(Selectors.byText("ელ. ფოსტა სავალდებულოა")).getText());
        $(".form-control").click();
        $("#confirmPassword").click();
        Assert.assertEquals("პაროლი სავალდებულოა.", $(Selectors.byText("პაროლი სავალდებულოა.")).getText());
        sleep(5000);


        sleep(5000);

    }
}