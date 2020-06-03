package com.example.finsl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Module extends AppCompatActivity {
    TextView mModule;
    TextView mBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        mModule = findViewById(R.id.moduleText);
        mBook   = findViewById(R.id.bookText);

        Bundle bundle = getIntent().getExtras();
        String sub = bundle.getString("sub");
        String module = bundle.getString("mod");
        if(sub.equals("Physics"))
        {
            if(module.equals(""+1))
            {
                mModule.setText("Classical Dynamics: Newton’s laws of motion, generalised coordinates, constraints, Principle of virtual work, D’ Alembert’s Principle, Lagrangian, Action " +
                        "principle, Lagrange equation of motion (no derivation) and its application to" +
                        "Simple Harmonic oscillator and simple pendulum.\n" +
                        "\nGeneral properties of Matter: Stress, Strain, Hooks’ law, Young’s modulus.\n" +
                        "\nOscillation & Waves: Simple Harmonic Oscillation, damped harmonic os" +
                        "cillation, Forced oscillator, resonance, coupled oscillation, concept of wave and" +
                        "wave equation.\n" +
                        "\nOptics: Concept of interference, two source interference pattern, Biprism," +
                        "Michelson Interferometer & measurement of wavelength. Diffraction: Huygens" +
                        "principle, Fresnel & Fraunhofer diffraction, Zone plate, Plane diffraction grating" +
                        "(formula only)");
            }
            else if (module.equals(""+2))
                mModule.setText("Solid State Physics: Crystalline and amorphous solid, unit cell, Miller In" +
                        "dices, Reciprocal lattice, Bragg’s law, Brillouin’s zone, concept of fermions, " +
                        "Maxwell-Boltzmann, Fermi-Dirac and Bose-Einstein distribution function (only" +
                        "statement and formula), Concept of Fermions and Bosons.\n\n Classification of ma" +
                        "terials: metals, semiconductor and insulator in terms of band theory.\n" +
                        "\nLASER and Fibre Optics: Principle and application, stimulated emission, " +
                        "population inversion, Lasing material (solid and gas), He-Ne laser, Rubi- LASER, " +
                        "Application of LASER (Engineering Application), Principle of optical fibre and " +
                        "its application to communication.");
            else if(module.equals(""+3))
                mModule.setText("Electromagnetism: Student will be familiarized with some basics used in vec" +
                        "tor calculus prior to development of Maxwell’s electromagnetic wave equations. " +
                        "No proof of theorems and laws included in this unit expected- statement and " +
                        "interpretation should sufficient.\n" +
                        "a) Vector calculus: gradient of scalar field, divergence, curl of vector field (Only " +
                        "Physical significance) Gauss divergence theorem, Stoke’s theorem, Green’s the" +
                        "orem (Only Statements) and applications.\n" +
                        "b) Gauss’s law of electrostatics in free space and in a medium and application " +
                        "(Only statements) electric displacement (D) magnetic Induction (B), Amperes " +
                        "circuital law (Only statements), displacement current, Faraday’s law of elec" +
                        "tromagnetic induction (Only statements), Biot Savarts Law (Only statements), " +
                        "Maxwell’s four electromagnetic equations, Wave equation for E and B fields in " +
                        "vacuum, Electromagnetic energy, Poynting vector (no derivation).\n\n" +
                        "Quantum Physics: Elementary concepts of quantum physics formulation to " +
                        "deal with physical systems.\n" +
                        "a) Need for Quantum physics-Historical overviews, Particle aspects of radiation- " +
                        "Black body radiation, photoelectric effect, Compton scattering, pair production." +
                        "(No derivations), Wave aspect of particles- matter wave, de Broglie Hypothesis, " +
                        "Heisenberg Uncertainty principles- Statement, Interpretation and application to " +
                        "H-atom, Harmonic oscillator to calculate ground state energy.\n" +
                        "b) Basic features of Quantum mechanics- Transition from deterministic to prob" +
                        "abilistic, States of system- Wave function, probability density, superposition " +
                        "principle, observables and operators, expectation values. Schrodinger equation-" +
                        "Time dependent and time independent, wave packets.");
            else
                mModule.setText(module);
            mBook.setText("Text Books:\n" +
                    "\n1. L. Maharana, P. K. Panda, S. N. Dash, B. Ojha, Lectures in Engineering " +
                    "Physics, Pearson.\n" +
                    "\nReference Books:\n" +
                    "\n1. An Introduction to Mechanics -D. Klippner & R. Kolenkow, TMH\n" +
                    "2. Concepts of Modern Physics - Arthur Beiser.\n" +
                    "3. Electricity & Magnetism -E. M. Purecell\n" +
                    "4. Engineering Physics by D. K. Bhattacharya and Poonam Tandon, Oxford\n" +
                    "University Press\n" +
                    "5. Engineering Physics by D. R. Joshi, Mc Graw Hill\n" +
                    "6. Introduction to Electrodynamics- David J. Griffiths, PHI Publication\n" +
                    "7. Optics- A. K. Ghatak\n" +
                    "8. Physics-I for engineering degree students- B. B. Swain and P. K. Jena.\n" +
                    "9. Quantum Mechanics -Powel & Craseman.\n" +
                    "10. Quantum Physics - Gasiorowicz");
        }
        else
            mModule.setText(sub);
    }
}
