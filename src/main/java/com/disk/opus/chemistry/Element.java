package com.disk.opus.chemistry;

public enum Element
{
    R_GROUP("R", 0.0001f, 2.5f),
    //alkali metals
    LITHIUM("Li", 6.941f, 0.9f),
    SODIUM("Na", 22.990f, 0.9f),
    POTASSIUM("K", 39.098f, 0.8f),
    RUBIDIUM("Rb", 85.468f, 0.8f),
    CESIUM("Cs", 132.905f, 0.7f),
    //alkaline metals
    BERYLLIUM("Be", 9.012f, 1.5f),
    MAGNESIUM("Mg", 24.305f, 1.3f),
    CALCIUM("Ca", 40.078f, 1.0f),
    STRONTIUM("Sr", 87.62f, 0.9f),
    BARIUM("Ba", 137.328f, 0.8f),
    RADIUM("Ra", 226.025f, 0.8f),
    //noble gases
    HELIUM("He", 4.003f, 0.0f),
    NEON("Ne", 20.180f, 0.0f),
    ARGON("Ar", 39.948f, 0.0f),
    KRYPTON("Kr", 83.798f, 3.0f),
    XENON("Xe", 131.294f, 2.6f),
    RADON("Ra", 222.018f, 0.0f),
    //halogens
    FLUORINE("F", 18.998f, 3.9f),
    CHLORINE("Cl", 35.453f, 3.1f),
    BROMINE("Br", 79.904f, 2.9f),
    IODINE("I", 126.904f, 2.6f),
    ASTATINE("At", 209.987f, 2.2f),
    //nonmetals
    BORON("B", 10.811f, 2.0f),
    CARBON("C", 12.011f, 2.5f), //holy in its own right
    NITROGEN("N", 14.007f, 3.0f),
    OXYGEN("O", 15.999f, 3.4f),
    SILICON("Si", 28.086f, 1.9f),
    PHOSPHORUS("P", 30.974f, 2.1f),
    SULFUR("S", 32.066f, 2.5f),
    ARSENIC("As", 74.922f, 2.1f),
    SELENIUM("Se", 78.971f, 2.5f),
    TELLURIUM("Te", 127.6f, 2.1f),
    //metals
    ALUMINIUM("Al", 26.982f, 1.6f),
    GALLIUM("Ga", 69.723f, 1.8f),
    GERMANIUM("Ge", 72.631f, 2.0f),
    INDIUM("In", 114.818f, 1.7f),
    TIN("Sn", 118.711f, 1.9f),
    ANTIMONY("Sb", 121.760f, 2.0f),
    THALLIUM("Tl", 204.383f, 1.6f),
    LEAD("Pb", 207.2f, 2.3f),
    BISMUTH("Bi", 208.980f, 2.0f),
    POLONIUM("Po", 208.982f, 2.0f),
    //rare-earth metals
    SCANDIUM("Sc", 44.956f, 1.3f),
    YTTRIUM("Y", 88.906f, 1.2f),
    //transition metals
    TITANIUM("Ti", 47.88f, 1.5f),
    VANADIUM("V", 50.942f, 1.6f),
    CHROMIUM("Cr", 51.996f, 1.6f),
    MANGANESE("Mn", 54.938f, 1.5f),
    IRON("Fe", 55.845f, 1.8f),
    COBALT("Co", 58.933f, 1.8f),
    NICKEL("Ni", 58.693f, 1.9f),
    COPPER("Cu", 63.546f, 1.9f),
    ZINC("Zn", 65.38f, 1.6f),
    ZIRCONIUM("Zr", 91.224f, 1.3f),
    NIOBIUM("Nb", 92.906f, 1.6f),
    MOLYBDENUM("Mo", 95.95f, 2.1f),
    TECHNETIUM("Tc", 98.907f, 1.9f),
    RUTHENIUM("Ru", 101.07f, 2.2f),
    RHODIUM("Rh", 102.906f, 2.2f),
    PALLADIUM("Pd", 106.42f, 2.2f),
    SILVER("Ag", 107.868f, 1.9f),
    CADMIUM("Cd", 112.414f, 1.6f),
    HAFNIUM("Hf", 178.49f, 1.3f),
    TANTALUM("Ta", 180.948f, 1.5f),
    TUNGSTEN("W", 183.85f, 2.3f),
    RHENIUM("Re", 186.207f, 1.9f),
    OSMIUM("Os", 190.23f, 2.2f),
    IRIDIUM("Ir", 192.22f, 2.2f),
    PLATINUM("Pt", 195.08f, 2.2f),
    GOLD("Au", 196.967f, 2.5f),
    MERCURY("Hg", 200.59f, 2.0f),
    //lanthanides
    LANTHANUM("La", 138.905f, 1.1f),
    CERIUM("Ce", 140.116f, 1.1f),
    PRASEODYMIUM("Pr", 140.908f, 1.1f),
    NEODYMIUM("Nd", 144.243f, 1.1f),
    PROMETHIUM("Pm", 144.913f, 1.1f),
    SAMARIUM("Sm", 150.36f, 1.1f),
    EUROPIUM("Eu", 151.964f, 1.2f),
    GADOLINIUM("Gd", 157.25f, 1.2f),
    TERBIUM("Tb", 158.925f, 1.2f),
    DYSPROSIUM("Dy", 162.500f, 1.2f),
    HOLMIUM("Ho", 164.930f, 1.2f),
    ERBIUM("Er", 167.258f, 1.2f),
    THULIUM("Tm", 168.934f, 1.2f),
    YTTERBIUM("Yb", 173.055f, 1.1f),
    LUTETIUM("Lu", 174.900f, 1.2f),
    //actinides
    ACTINIUM("Ac", 227.028f, 1.1f),
    THORIUM("Th", 232.038f, 1.3f),
    PROTACTINIUM("Pa", 231.036f, 1.5f),
    URANIUM("U", 238.029f, 1.3f),
    NEPTUNIUM("Np", 237.048f, 1.3f),
    PLUTONIUM("Pu", 244.064f, 1.2f),
    AMERICIUM("Am", 243.061f, 1.3f),
    CURIUM("Cm", 247.070f, 1.3f),
    BERKELIUM("Bk", 247.070f, 1.3f),
    CALIFORNIUM("Cf", 251.080f, 1.3f),
    //stopping here cuz the rest are rather unstable/have few uses
    ;

    private Element(String symbol, Float mass, Float electronegativity)
    {
        
    }
}
