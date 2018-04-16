package com.crud.tasks.trello.config;

import com.crud.tasks.config.AdminConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminConfigTestSuite {

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void testAdminMail() {
        //Given
        String adminMail = "pgontektests@gmail.com";
        when(adminConfig.getAdminMail()).thenReturn(adminMail);
        //When
        String testAdminMail = adminConfig.getAdminMail();
        //Then
        Assert.assertEquals(adminMail, testAdminMail);
    }
}