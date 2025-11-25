package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

public class ZElementController {
    @FXML private Label descriptionLabel;
    
    @FXML
    private void showDescription(MouseEvent event) {
        Button button = (Button) event.getSource();
        String element = button.getText();
        descriptionLabel.setText(getElementDescription(element));
    }
    
    @FXML
    private void hideDescription() {
        descriptionLabel.setText("Hover over an element to see its description");
    }
    
    @FXML
    private void handleBackButton() {
        SceneController.getInstance().switchToScene("sciScene");
    }
    
    private String getElementDescription(String element) {
        switch(element) {
            case "H": return "Hydrogen: Lightest element, atomic number 1. Essential for water, fuels stars, and used in fuel cells.";
            case "He": return "Helium: Noble gas, atomic number 2. Used in cryogenics, balloons, and as a coolant for superconductors.";
            case "Li": return "Lithium: Alkali metal, atomic number 3. Critical in rechargeable batteries and mood-stabilizing drugs.";
            case "Be": return "Beryllium: Alkaline earth metal, atomic number 4. Used in aerospace materials and X-ray windows.";
            case "B": return "Boron: Metalloid, atomic number 5. Found in detergents, borosilicate glass, and fertilizers.";
            case "C": return "Carbon: Non-metal, atomic number 6. Basis of life, found in organic compounds, diamonds, and graphite.";
            case "N": return "Nitrogen: Non-metal, atomic number 7. Makes up 78% of Earth's atmosphere, used in fertilizers and cryogenics.";
            case "O": return "Oxygen: Non-metal, atomic number 8. Essential for respiration, water, and combustion.";
            case "F": return "Fluorine: Halogen, atomic number 9. Found in toothpaste, Teflon, and as a key industrial reagent.";
            case "Ne": return "Neon: Noble gas, atomic number 10. Used in neon signs and high-voltage indicators.";
            case "Na": return "Sodium: Alkali metal, atomic number 11. Key in salt (NaCl) and used in chemical synthesis.";
            case "Mg": return "Magnesium: Alkaline earth metal, atomic number 12. Used in lightweight alloys and as a dietary supplement.";
            case "Al": return "Aluminum: Post-transition metal, atomic number 13. Found in packaging, construction, and airplanes.";
            case "Si": return "Silicon: Metalloid, atomic number 14. Integral to semiconductors, glass, and construction materials.";
            case "P": return "Phosphorus: Non-metal, atomic number 15. Essential in DNA, ATP, and fertilizers.";
            case "S": return "Sulfur: Non-metal, atomic number 16. Found in sulfuric acid, fertilizers, and vulcanized rubber.";
            case "Cl": return "Chlorine: Halogen, atomic number 17. Used in disinfectants, PVC production, and water treatment.";
            case "Ar": return "Argon: Noble gas, atomic number 18. Used in welding, light bulbs, and as an inert gas in laboratories.";
            case "K": return "Potassium: Alkali metal, atomic number 19. Vital for cell function and found in fertilizers.";
            case "Ca": return "Calcium: Alkaline earth metal, atomic number 20. Critical for bones, shells, and cement.";
            case "Sc": return "Scandium: Transition metal, atomic number 21. Used in aerospace components and metal halide lamps.";
            case "Ti": return "Titanium: Transition metal, atomic number 22. Found in strong, lightweight alloys and medical implants.";
            case "V": return "Vanadium: Transition metal, atomic number 23. Used in steel alloys and as a catalyst in chemical processes.";
            case "Cr": return "Chromium: Transition metal, atomic number 24. Found in stainless steel and chrome plating.";
            case "Mn": return "Manganese: Transition metal, atomic number 25. Used in steel production and batteries.";
            case "Fe": return "Iron: Transition metal, atomic number 26. Core component of steel and essential for blood hemoglobin.";
            case "Co": return "Cobalt: Transition metal, atomic number 27. Used in superalloys, batteries, and pigments.";
            case "Ni": return "Nickel: Transition metal, atomic number 28. Found in stainless steel, coins, and rechargeable batteries.";
            case "Cu": return "Copper: Transition metal, atomic number 29. Excellent conductor used in wiring, electronics, and plumbing.";
            case "Zn": return "Zinc: Transition metal, atomic number 30. Used in galvanizing, alloys, and as a trace dietary mineral.";
            case "Ga": return "Gallium: Post-transition metal, atomic number 31. Melts in hand, used in semiconductors and LEDs.";
            case "Ge": return "Germanium: Metalloid, atomic number 32. Used in fiber optics, infrared optics, and semiconductors.";
            case "As": return "Arsenic: Metalloid, atomic number 33. Historically used in pesticides, now in semiconductors and alloys.";
            case "Se": return "Selenium: Non-metal, atomic number 34. Used in photocopiers, glassmaking, and as a dietary supplement.";
            case "Br": return "Bromine: Halogen, atomic number 35. Found in flame retardants, photography chemicals, and fumigants.";
            case "Kr": return "Krypton: Noble gas, atomic number 36. Used in lighting, flash photography, and as an insulating gas.";
            case "Rb": return "Rubidium: Alkali metal, atomic number 37. Used in atomic clocks and specialty glasses.";
            case "Sr": return "Strontium: Alkaline earth metal, atomic number 38. Found in fireworks, ceramics, and radiological markers.";
            case "Y": return "Yttrium: Transition metal, atomic number 39. Used in lasers, superconductors, and phosphors in LEDs.";
            case "Zr": return "Zirconium: Transition metal, atomic number 40. Corrosion-resistant, used in nuclear reactors and ceramics.";
            case "Nb": return "Niobium: Transition metal, atomic number 41. Used in superconductors and strengthening steel alloys.";
            case "Mo": return "Molybdenum: Transition metal, atomic number 42. Essential in enzymes, used in steel alloys and catalysts.";
            case "Tc": return "Technetium: Transition metal, atomic number 43. Radioactive, used in medical imaging and research.";
            case "Ru": return "Ruthenium: Transition metal, atomic number 44. Found in electronics, catalysts, and jewelry plating.";
            case "Rh": return "Rhodium: Transition metal, atomic number 45. Highly reflective, used in catalysts and mirror coatings.";
            case "Pd": return "Palladium: Transition metal, atomic number 46. Used in catalytic converters, jewelry, and electronics.";
            case "Ag": return "Silver: Transition metal, atomic number 47. Excellent conductor, used in electronics, jewelry, and photography.";
            case "Cd": return "Cadmium: Transition metal, atomic number 48. Found in batteries, pigments, and coatings.";
            case "In": return "Indium: Post-transition metal, atomic number 49. Used in touchscreens, solar panels, and LEDs.";
            case "Sn": return "Tin: Post-transition metal, atomic number 50. Used in solder, coatings, and alloys such as bronze.";
            case "Sb": return "Antimony: Metalloid, atomic number 51. Used in flame retardants, alloys, and semiconductors.";
            case "Te": return "Tellurium: Metalloid, atomic number 52. Used in thermoelectric devices and alloys.";
            case "I": return "Iodine: Halogen, atomic number 53. Essential for thyroid health, used in antiseptics and photography.";
            case "Xe": return "Xenon: Noble gas, atomic number 54. Found in flash lamps, anesthesia, and ion propulsion systems.";
            case "Cs": return "Cesium: Alkali metal, atomic number 55. Used in atomic clocks, drilling fluids, and photoelectric cells.";
            case "Ba": return "Barium: Alkaline earth metal, atomic number 56. Used in X-ray imaging, fireworks, and ceramics.";
            case "La": return "Lanthanum: Lanthanide, atomic number 57. Found in camera lenses, catalysts, and hybrid vehicle batteries.";
            case "Ce": return "Cerium: Lanthanide, atomic number 58. Used in catalytic converters, glass polishing, and alloys.";
            case "Pr": return "Praseodymium: Lanthanide, atomic number 59. Used in magnets, lasers, and aircraft engines.";
            case "Nd": return "Neodymium: Lanthanide, atomic number 60. Found in powerful magnets, lasers, and glass coloring.";
            case "Pm": return "Promethium: Lanthanide, atomic number 61. Radioactive, used in luminous paints and nuclear batteries.";
            case "Sm": return "Samarium: Lanthanide, atomic number 62. Used in magnets, nuclear reactors, and lasers.";
            case "Eu": return "Europium: Lanthanide, atomic number 63. Key in phosphorescent materials for TVs and LED lights.";
            case "Gd": return "Gadolinium: Lanthanide, atomic number 64. Used in MRI contrast agents, alloys, and neutron capture.";
            case "Tb": return "Terbium: Lanthanide, atomic number 65. Found in phosphors for LEDs and as a stabilizer in magnets.";
            case "Dy": return "Dysprosium: Lanthanide, atomic number 66. Used in high-performance magnets and nuclear reactor control rods.";
            case "Ho": return "Holmium: Lanthanide, atomic number 67. Used in lasers, magnets, and as a neutron absorber.";
            case "Er": return "Erbium: Lanthanide, atomic number 68. Used in fiber optics, lasers, and glass coloring.";
            case "Tm": return "Thulium: Lanthanide, atomic number 69. Used in portable X-ray devices and lasers.";
            case "Yb": return "Ytterbium: Lanthanide, atomic number 70. Used in stainless steel, atomic clocks, and medical devices.";
            case "Lu": return "Lutetium: Lanthanide, atomic number 71. Used in PET scanners, catalysts, and research applications.";
            case "Hf": return "Hafnium: Transition metal, atomic number 72. Found in nuclear control rods, alloys, and microchips.";
            case "Ta": return "Tantalum: Transition metal, atomic number 73. Highly corrosion-resistant, used in electronics and surgical implants.";
            case "W": return "Tungsten: Transition metal, atomic number 74. Known for high melting point, used in filaments and cutting tools.";
            case "Re": return "Rhenium: Transition metal, atomic number 75. Used in jet engines, thermocouples, and catalysts.";
            case "Os": return "Osmium: Transition metal, atomic number 76. Densest element, used in fountain pen tips and electrical contacts.";
            case "Ir": return "Iridium: Transition metal, atomic number 77. Highly corrosion-resistant, used in spark plugs and medical devices.";
            case "Pt": return "Platinum: Transition metal, atomic number 78. Found in catalytic converters, jewelry, and fuel cells.";
            case "Au": return "Gold: Transition metal, atomic number 79. Valued for its conductivity, malleability, and use in electronics and jewelry.";
            case "Hg": return "Mercury: Transition metal, atomic number 80. Liquid at room temperature, used in thermometers and barometers.";
            case "Tl": return "Thallium: Post-transition metal, atomic number 81. Used in electronics, optical lenses, and historically in pesticides.";
            case "Pb": return "Lead: Post-transition metal, atomic number 82. Found in batteries, radiation shielding, and historically in pipes and paints.";
            case "Bi": return "Bismuth: Post-transition metal, atomic number 83. Non-toxic, used in medications, alloys, and cosmetics.";
            case "Po": return "Polonium: Metalloid, atomic number 84. Radioactive, used in research and as a heat source in space probes.";
            case "At": return "Astatine: Halogen, atomic number 85. Rare and radioactive, studied for potential use in cancer treatment.";
            case "Rn": return "Radon: Noble gas, atomic number 86. Radioactive, used in cancer therapy and studied for geological purposes.";
            case "Fr": return "Francium: Alkali metal, atomic number 87. Extremely rare and radioactive, used in atomic research.";
            case "Ra": return "Radium: Alkaline earth metal, atomic number 88. Historically used in luminous paints, now in cancer treatment.";
            case "Ac": return "Actinium: Actinide, atomic number 89. Radioactive, used in radiation therapy and research.";
            case "Th": return "Thorium: Actinide, atomic number 90. Used in nuclear reactors and as a potential fuel in nuclear energy.";
            case "Pa": return "Protactinium: Actinide, atomic number 91. Rare and radioactive, used in nuclear research.";
            case "U": return "Uranium: Actinide, atomic number 92. Known for its use as nuclear fuel and in atomic weapons.";
            case "Np": return "Neptunium: Actinide, atomic number 93. Radioactive, used in neutron detection and nuclear science.";
            case "Pu": return "Plutonium: Actinide, atomic number 94. Used in nuclear reactors, weapons, and as a power source in space exploration.";
            case "Am": return "Americium: Actinide, atomic number 95. Found in smoke detectors and used in neutron sources.";
            case "Cm": return "Curium: Actinide, atomic number 96. Radioactive, used in space missions and nuclear research.";
            case "Bk": return "Berkelium: Actinide, atomic number 97. Synthetic element, used in research and production of heavier elements.";
            case "Cf": return "Californium: Actinide, atomic number 98. Used in neutron sources and cancer treatments.";
            case "Es": return "Einsteinium: Actinide, atomic number 99. Highly radioactive, used in scientific research.";
            case "Fm": return "Fermium: Actinide, atomic number 100. Synthetic, with limited applications in nuclear science.";
            case "Md": return "Mendelevium: Actinide, atomic number 101. Radioactive, used only in research.";
            case "No": return "Nobelium: Actinide, atomic number 102. Synthetic, with applications limited to scientific study.";
            case "Lr": return "Lawrencium: Actinide, atomic number 103. Radioactive, used in scientific research.";
            case "Rf": return "Rutherfordium: Transition metal, atomic number 104. Synthetic, with applications limited to research.";
            case "Db": return "Dubnium: Transition metal, atomic number 105. Synthetic, used in nuclear and chemical research.";
            case "Sg": return "Seaborgium: Transition metal, atomic number 106. Radioactive, with uses confined to scientific study.";
            case "Bh": return "Bohrium: Transition metal, atomic number 107. Synthetic, primarily used in research.";
            case "Hs": return "Hassium: Transition metal, atomic number 108. Radioactive, used in high-energy physics research.";
            case "Mt": return "Meitnerium: Transition metal, atomic number 109. Extremely rare, with applications in scientific research.";
            case "Ds": return "Darmstadtium: Transition metal, atomic number 110. Synthetic and short-lived, used in research.";
            case "Rg": return "Roentgenium: Transition metal, atomic number 111. Extremely rare, with no practical applications.";
            case "Cn": return "Copernicium: Transition metal, atomic number 112. Radioactive and synthetic, studied in research.";
            case "Nh": return "Nihonium: Post-transition metal, atomic number 113. Highly unstable, used only in scientific research.";
            case "Fl": return "Flerovium: Post-transition metal, atomic number 114. Synthetic, studied for its unusual stability.";
            case "Mc": return "Moscovium: Post-transition metal, atomic number 115. Radioactive, with research focusing on its properties.";
            case "Lv": return "Livermorium: Post-transition metal, atomic number 116. Radioactive, with applications limited to research.";
            case "Ts": return "Tennessine: Halogen, atomic number 117. Highly unstable, studied for its placement in the periodic table.";
            case "Og": return "Oganesson: Noble gas, atomic number 118. Heaviest element, with unique and unstable properties studied in research.";
            default: return "Element information not available";
        }
    }
}