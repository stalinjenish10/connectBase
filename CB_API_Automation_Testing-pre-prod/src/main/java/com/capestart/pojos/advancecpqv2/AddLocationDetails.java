package com.capestart.pojos.advancecpqv2;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Accessors(chain = true)
@Data
public class AddLocationDetails {
  ArrayList<String> locations;
}
