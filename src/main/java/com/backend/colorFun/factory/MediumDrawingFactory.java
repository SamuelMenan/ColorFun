package com.backend.colorFun.factory;

import com.backend.colorFun.model.Drawing;
import org.springframework.stereotype.Component;

@Component
public class MediumDrawingFactory extends BaseDrawingFactory {
  @Override
  public String level() { return "medium"; }

  @Override
  public Drawing create(String id) {
        String svg = """
            <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 500 350\" width=\"700\">
              <style>.region{cursor:pointer;stroke:#444;stroke-width:2}</style>
              <g id=\"drawing\">
                <rect id=\"trunk\" class=\"region\" x=\"230\" y=\"220\" width=\"40\" height=\"80\" fill=\"#ffffff\" />
                <circle id=\"leaf1\" class=\"region\" cx=\"250\" cy=\"150\" r=\"60\" fill=\"#ffffff\" />
                <circle id=\"leaf2\" class=\"region\" cx=\"200\" cy=\"180\" r=\"50\" fill=\"#ffffff\" />
                <circle id=\"leaf3\" class=\"region\" cx=\"300\" cy=\"180\" r=\"50\" fill=\"#ffffff\" />
                <text x=\"16\" y=\"28\" font-size=\"18\" fill=\"#444\">LEVEL: MEDIUM</text>
              </g>
            </svg>
            """;
    return new Drawing(id, level(), svg);
    }
}
