package com.backend.colorFun.factory;

import com.backend.colorFun.model.Drawing;
import org.springframework.stereotype.Component;

@Component
public class HardDrawingFactory extends BaseDrawingFactory {
  @Override
  public String level() { return "hard"; }

  @Override
  public Drawing create(String id) {
        String svg = """
            <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 600 400\" width=\"760\">
              <style>.region{cursor:pointer;stroke:#8b0000;stroke-width:0.8}</style>
              <g id=\"drawing\">
                <circle id=\"sun\" class=\"region\" cx=\"80\" cy=\"80\" r=\"40\" fill=\"#ffffff\" />
                <g id=\"cloud\" transform=\"translate(140,60)\">
                  <ellipse class=\"region\" cx=\"0\" cy=\"0\" rx=\"30\" ry=\"18\" fill=\"#ffffff\" />
                  <ellipse class=\"region\" cx=\"30\" cy=\"-6\" rx=\"28\" ry=\"16\" fill=\"#ffffff\" />
                </g>
                <path id=\"hill\" class=\"region\" d=\"M0,300 Q150,180 300,300 T600,300 L600,400 L0,400 Z\" fill=\"#ffffff\" />
                <rect id=\"house-wall\" class=\"region\" x=\"350\" y=\"200\" width=\"140\" height=\"100\" fill=\"#ffffff\" />
                <polygon id=\"house-roof\" class=\"region\" points=\"340,200 420,150 500,200\" fill=\"#ffffff\" />
                <text x=\"20\" y=\"32\" font-size=\"18\" fill=\"#8b0000\">LEVEL: HARD</text>
              </g>
            </svg>
            """;
    return new Drawing(id, level(), svg);
    }
}
