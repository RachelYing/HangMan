package edu.neu.ccs.cs5004.assignmnet11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RachelDi on 11/04/2017.
 */
public class MessageContentTest {
  int life1;
  int life2;
  int life3;
  int life4;
  int life5;
  int numMark1;
  int numMark2;
  MessageContent content;

  @Before
  public void setUp() throws Exception {
    life1 = 2;
    numMark1 = 2;
    content = new MessageContent();
    life2 = 1;
    numMark2 = 0;
    life3 = 0;
    life4 = 1;
    life5 = -1;
  }

  @Test
  public void message() throws Exception {
    Assert.assertEquals("2 guesses left", content.message(life1, numMark1));
    Assert.assertEquals("1 guess left", content.message(life2, numMark1));
    Assert.assertEquals("You won with 0 guess left!", content.message(life3, numMark2));
    Assert.assertEquals("You won with 1 guess left!", content.message(life4, numMark2));
    Assert.assertEquals("You won with 2 guesses left!", content.message(life1, numMark2));
    Assert.assertEquals("You lost! (dullard)", content.message(life5, numMark1));
  }
}