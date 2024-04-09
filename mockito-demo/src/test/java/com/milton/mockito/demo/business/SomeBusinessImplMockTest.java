package com.milton.mockito.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
  
  @Mock
  private DataService dataServiceMock;
  
  @Test
  void findTheGreatestFromAllData_basicScenario() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 15, 5});
    SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
    assertEquals(25, businessImpl.findTheGreatestFromAllData());
  }
  
  @Test
  void findTheGreatestFromAllData_OneValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
    SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
    assertEquals(35, businessImpl.findTheGreatestFromAllData());
  }

}