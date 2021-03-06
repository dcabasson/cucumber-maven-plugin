package org.codehaus.mojo.cucumber;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.maven.doxia.module.confluence.ConfluenceSinkFactory;
import org.apache.maven.doxia.sink.Sink;
import org.junit.Assert;
import org.junit.Test;

public class MarkdownParsingTest {
    
    final String stringToParse = "In order to have staff respond to respondent inquiries\r\n" + 
            "As a telephone operator\r\n" + 
            "I need to be able to send an inquiry from the inbox to Jira\r\n" + 
            "\r\n" + 
            "**Acceptance criteria:**\r\n" + 
            "\r\n" + 
            "The following service request reasons are the different types of inquiries available:\r\n" + 
            "\r\n" + 
            "* Technical support inquiry\r\n" + 
            "* Public relations inquiry\r\n" + 
            "* Subject matter inquiry\r\n" + 
            "\r\n" + 
            "Once the operator selects the service request reason, he will also have to select a survey for which the inquiry is about and confirm the caller's contact information.\r\n" + 
            "\r\n" + 
            "The operator can only select a survey if they have a field assignment for that survey.\r\n" + 
            "\r\n" + 
            "The following contact information fields will be displayed:\r\n" + 
            "\r\n" + 
            "* Given and family name (mandatory)\r\n" + 
            "* Contact language  (mandatory)\r\n" + 
            "* Telephone number / Caller does not have or does not wish to provide a telephone number (mandatory)\r\n" + 
            "* Best time to reach respondent  (mandatory)\r\n" + 
            "* Comments\r\n" + 
            "\r\n" + 
            "Once the operator submits the service request, the following information will be used to generate a service request case:\r\n" + 
            "\r\n" + 
            "* Interview/Enumeration case number\r\n" + 
            "* Service request reason (including priority)\r\n" + 
            "* Survey\r\n" + 
            "* Address from unit profile (comes from the system - will not be read from the unit profile)\r\n" + 
            "* Contact name\r\n" + 
            "* Contact language\r\n" + 
            "* Telephone number / Caller does not have or does not wish to provide a telephone number\r\n" + 
            "* Best time to reach respondent\r\n" + 
            "* Comments\r\n" + 
            "* Case level details will come from the system: Case number, WEIGHT, TELEPHONE_PRIORITY, FIELD_PRIORITY\r\n" + 
            "\r\n" + 
            "A unique 8 digit case number will be generated by the system\r\n" + 
            "\r\n" + 
            "These service request cases will be assigned a priority of 0 to prevent them from being actioned by telephone or field staff.\r\n" + 
            "\r\n" + 
            "Mandatory case details:\r\n" + 
            "\r\n" + 
            "* TELEPHONE_PRIORITY = 0\r\n" + 
            "\r\n" + 
            "* WEIGHT = 1\r\n" + 
            "\r\n" + 
            "* FIELD_PRIORITY = 0\r\n" + 
            "\r\n" + 
            "Upon creation of the service request case:\r\n" + 
            "\r\n" + 
            "* The case number will be displayed\r\n" + 
            "\r\n" + 
            "* An event will be populated on the related case from which the Service request was created\r\n" + 
            "\r\n" + 
            "* A Jira ticket will be created to inform CHL staff of the inquiry\r\n" + 
            "\r\n" + 
            "* The service request case will be resolved right away.\r\n" + 
            "\r\n" + 
            "\r\n" + 
            "<img src=\"http://icos-doc/prototype/screenshots/telephoneOperator/enterServiceRequest/inquiries/selectServiceRequest.png\"></img>\r\n" + 
            "\r\n" + 
            "<img src=\"http://icos-doc/prototype/screenshots/telephoneOperator/enterServiceRequest/inquiries/inquiries-contactInfo.png\"></img>\r\n" + 
            "\r\n" + 
            "<img src=\"http://icos-doc/prototype/screenshots/telephoneOperator/enterServiceRequest/inquiries/submitted.png\"></img>";
    
    final String otherStringToParse = "In order to have staff respond to respondent inquiries\r\n" + 
            "As a telephone operator\r\n" + 
            "I need to be able to send an inquiry from a linked dwelling to Jira\r\n" + 
            "\r\n" + 
            "**Acceptance criteria:**\r\n" + 
            "\r\n" + 
            "The following service request reasons are the different types of inquiries available:\r\n" + 
            "\r\n" + 
            "* Technical support inquiry\r\n" + 
            "* Public relations inquiry\r\n" + 
            "* Subject matter inquiry\r\n" + 
            "\r\n" + 
            "Once the operator selects the service request reason, he will also have to confirm the respondent's contact information.\r\n" + 
            "\r\n" + 
            "The following fields will be displayed:\r\n" + 
            "\r\n" + 
            "* Given and family name (mandatory)\r\n" + 
            "* Contact language  (mandatory)\r\n" + 
            "* Telephone number / Caller does not have or does not wish to provide a telephone number (mandatory)\r\n" + 
            "* Best time to reach respondent  (mandatory)\r\n" + 
            "* Comments\r\n" + 
            "\r\n" + 
            "Once the operator submits the service request, the following information will be used to generate a service request case:\r\n" + 
            "\r\n" + 
            "* Interview/Enumeration case number\r\n" + 
            "* Service request reason (including priority)\r\n" + 
            "* Survey\r\n" + 
            "* Address from unit profile (comes from the system - will not be read from the unit profile)\r\n" + 
            "* Contact name\r\n" + 
            "* Contact language\r\n" + 
            "* Telephone number / Caller does not have or does not wish to provide a telephone number\r\n" + 
            "* Best time to reach respondent\r\n" + 
            "* Comments\r\n" + 
            "* Case level details will come from the system: Case number, WEIGHT, TELEPHONE_PRIORITY, FIELD_PRIORITY\r\n" + 
            "\r\n" + 
            "A unique 8 digit case number will be generated by the system\r\n" + 
            "\r\n" + 
            "These service request cases will be assigned a priority of 0 to prevent them from being actioned by telephone or field staff.\r\n" + 
            "\r\n" + 
            "Mandatory case details:\r\n" + 
            "\r\n" + 
            "* TELEPHONE_PRIORITY = 0\r\n" + 
            "\r\n" + 
            "* WEIGHT = 1\r\n" + 
            "\r\n" + 
            "* FIELD_PRIORITY = 0\r\n" + 
            "\r\n" + 
            "Upon creation of the service request case:\r\n" + 
            "\r\n" + 
            "* The case number will be displayed\r\n" + 
            "\r\n" + 
            "* An event will be populated on the related case from which the Service request was created\r\n" + 
            "\r\n" + 
            "* A Jira ticket will be created to inform CHL staff of the inquiry\r\n" + 
            "\r\n" + 
            "* The service request case will be resolved right away.\r\n" + 
            "\r\n" + 
            "\r\n" + 
            "<img src=\"http://icos-doc/prototype/screenshots/telephoneOperator/enterServiceRequest/inquiries/selectServiceRequest.png\"></img>\r\n" + 
            "\r\n" + 
            "<img src=\"http://icos-doc/prototype/screenshots/telephoneOperator/enterServiceRequest/inquiries/inquiries-contactInfo.png\"></img>\r\n" + 
            "\r\n" + 
            "<img src=\"http://icos-doc/prototype/screenshots/telephoneOperator/enterServiceRequest/inquiries/submitted.png\"></img>";
    
    @Test
    public void testParseMd() {
      final String parsedString = FeaturesReport.parseDescriptionForMd(this.stringToParse);
      Assert.assertTrue(parsedString.length()>0);
    }
    
    @Test
    public void testParseThenParseMd() {
      final String parsedString = FeaturesReport.parseDescriptionForMd(this.stringToParse);
      Assert.assertTrue(parsedString.length()>0);
      final String otherParsedString = FeaturesReport.parseDescriptionForMd(this.otherStringToParse);
      Assert.assertTrue(otherParsedString.length()>0);
    }
    
    @Test
    public void testParseWaitParseMd() {
      final String parsedString = FeaturesReport.parseDescriptionForMd(this.stringToParse);
      Assert.assertTrue(parsedString.length()>0);
      try {
        TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
    }
      final String otherParsedString = FeaturesReport.parseDescriptionForMd(this.otherStringToParse);
      Assert.assertTrue(otherParsedString.length()>0);
    }
    
    @Test
    public void testParseBlankParseMd() {
      final String parsedString = FeaturesReport.parseDescriptionForMd(this.stringToParse);
      Assert.assertTrue(parsedString.length()>0);
      FeaturesReport.parseDescriptionForMd(StringUtils.EMPTY);
      FeaturesReport.parseDescriptionForMd(StringUtils.EMPTY);
      FeaturesReport.parseDescriptionForMd(StringUtils.EMPTY);
      FeaturesReport.parseDescriptionForMd(StringUtils.EMPTY);
      FeaturesReport.parseDescriptionForMd(StringUtils.EMPTY);
      FeaturesReport.parseDescriptionForMd(StringUtils.EMPTY);
      final String otherParsedString = FeaturesReport.parseDescriptionForMd(this.otherStringToParse);
      Assert.assertTrue(otherParsedString.length()>0);
    }
    
    @Test
    public void testParseSinkParseMd() throws Exception {
      final String parsedString = FeaturesReport.parseDescriptionForMd(this.stringToParse);
      Assert.assertTrue(parsedString.length()>0);
      final ConfluenceSinkFactory factory = new ConfluenceSinkFactory();
      final Sink confluenceSink = factory.createSink(new ByteArrayOutputStream(), "UTF-8");
      final String otherParsedString = FeaturesReport.parseDescriptionForMd(this.otherStringToParse);
      Assert.assertTrue(otherParsedString.length()>0);
    }


}
