package com.backend.colorFun.factory;

import com.backend.colorFun.model.Drawing;
import org.springframework.stereotype.Component;

@Component
public class EasyDrawingFactory extends BaseDrawingFactory {
  @Override
  public String level() { return "easy"; }

  @Override
  public Drawing create(String id) {
        String svg = """
            <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 400 300\" width=\"640\" height=\"480\">
              <style>.region{cursor:pointer;stroke:#2d6a4f;stroke-width:3}</style>
              <g id=\"drawing\">
                <polygon id=\"roof\" class=\"region\" data-region=\"roof\" points=\"50,120 200,40 350,120\" fill=\"#ffffff\" />
                <rect id=\"wall\" class=\"region\" data-region=\"wall\" x=\"90\" y=\"120\" width=\"220\" height=\"120\" fill=\"#ffffff\" />
                <rect id=\"door\" class=\"region\" data-region=\"door\" x=\"185\" y=\"180\" width=\"40\" height=\"60\" fill=\"#ffffff\" />
                <text x=\"12\" y=\"24\" font-size=\"18\" fill=\"#2d6a4f\">LEVEL: EASY</text>
              </g>
            </svg>
            """;
    return new Drawing(id, level(), svg);
    }
}
