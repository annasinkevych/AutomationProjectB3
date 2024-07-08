package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T00_login_docuport extends TestBase {

    @Test
    public void tes_login_logout_docuport() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT);
        DocuportUtils.logOut(driver);

        Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.EMPLOYEE);
        DocuportUtils.logOut(driver);

        Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        DocuportUtils.logOut(driver);

        Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.SUPERVISOR);
        DocuportUtils.logOut(driver);
    }



}
