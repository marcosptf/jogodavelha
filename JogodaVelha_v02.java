/**
 *@author:Marcos Paulo
 *@since:06/03/09
 *@desc:
 *este sera um jogo igual ao que nos desenvolvermos
 * em js, com uma inteligencia semelhante.
 * @version:0.2
 *
 * @pendencias:
 * neste release:
 * ->nos arrumamos o codigo que estava fora do padrao
 * ->tentamos corrigir a logica que estava com prolemas
 * ->este release foi descontinuado por inviabilidade tecnica
 *
 * falta arrumar:
 * ->separar classes dentro do pacote
 * ->placar
 * fazer funcionar como Applet
 *
 */

//package JogodaVelha;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JogodaVelha_v02 {

    //declaracao de variaveis
    public JLabel          point_gamer,point_java,null_1,null_2,null_3,null_4,null_5,
                           null_6,null_7,null_8,null_9,null_10,null_11;
    public JTextField      display_gamer,display_java;
    public JButton         b1,b2,b3,b4,b5,b6,b7,b8,b9,new_game,next_game,exit,info;
    public JPanel          panel;
    public JFrame          frame;
    public int             Gplacar=0,Jplacar=0;

    //metodo contrutor da gui
    public void contruct()
    {

        point_gamer     = new JLabel("Gamer:");
        point_java      = new JLabel("Java:");
        display_gamer   = new JTextField("0");
        display_java    = new JTextField("0");
        b1              = new JButton("");
        b2              = new JButton("");
        b3              = new JButton("");
        b4              = new JButton("");
        b5              = new JButton("");
        b6              = new JButton("");
        b7              = new JButton("");
        b8              = new JButton("");
        b9              = new JButton("");
        new_game        = new JButton("Novo");
        next_game       = new JButton("Proxima");
        exit            = new JButton("Sair");
        info            = new JButton("Info");
        panel           = new JPanel();
        frame           = new JFrame("Jogo da Velha v0.2");
        null_1          = new JLabel("");
        null_2          = new JLabel("");
        null_3          = new JLabel("");
        null_4          = new JLabel("");
        null_5          = new JLabel("");


        //contrucao do layout
        display_gamer.setEditable(false);
        display_java.setEditable(false);
        panel.setLayout(new GridLayout(5,4,1,1));
        panel.add(point_gamer);
        panel.add(display_gamer);
        panel.add(point_java);
        panel.add(display_java);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(null_1);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(null_2);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(null_3);
        panel.add(info);
        panel.add(exit);
        panel.add(new_game);
        panel.add(next_game);
        frame.add(panel);
        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adicao de eventos nos botoes
        //classe responsavel por tratar os eventos dos botoes auxiliares
        events evt = new events();
        exit.addActionListener(evt);
        info.addActionListener(evt);

        //classe para um novo jogo
        new_game ng = new new_game();
        new_game.addActionListener(ng);

        //classe para acionar uma proxima rodada
        next_game nxg = new next_game();
        next_game.addActionListener(nxg);

        //classe para tratar as acoes do jogo
        game gm = new game();
        b1.addActionListener(gm);
        b2.addActionListener(gm);
        b3.addActionListener(gm);
        b4.addActionListener(gm);
        b5.addActionListener(gm);
        b6.addActionListener(gm);
        b7.addActionListener(gm);
        b8.addActionListener(gm);
        b9.addActionListener(gm);

        //display do placar do jogo
        display  dp = new display();
        display_gamer.addActionListener(dp);
        display_java.addActionListener(dp);

    }

    public static void main(String[] args)
    {
        new JogodaVelha_v02().contruct();
    }


    //classe para manipular as condições de verificacao de ganhador
    //placar e engine do jogo
    class game implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            //pega o nome do botao
            Object source;
            source=event.getSource();
            display dp = new display();

            //primeiro eh verificado se ja ah um vencedor
            //caso nao haja ganhador...
            if(this.vencedor()==-1)
            {
               //como nao houve ganhador a jogatina continua...
               //segundo eh setada a jogada do gamer
                if(source==b1)
                {
                    //verifica se ja foi jogado neste botao
                    if((b1.getText().equals("X")) || (b1.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b1.getText().equals("")) || (b1.getText()==null))
                    {
                        b1.setText("X");
                    }

                }
                else if(source==b2)
                {
                    //verifica se ja foi jogado neste botao
                    if((b2.getText().equals("X")) || (b2.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b2.getText().equals("")) || (b2.getText()==null))
                    {
                        b2.setText("X");
                    }
                }
                else if(source==b3)
                {
                    //verifica se ja foi jogado neste botao
                    if((b3.getText().equals("X")) || (b3.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b3.getText().equals("")) || (b3.getText()==null))
                    {
                        b3.setText("X");
                    }
                }
                else if(source==b4)
                {
                    //verifica se ja foi jogado neste botao
                    if((b4.getText().equals("X")) || (b4.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b4.getText().equals("")) || (b4.getText()==null))
                    {
                        b4.setText("X");
                    }
                }
                else if(source==b5)
                {
                    //verifica se ja foi jogado neste botao
                    if((b5.getText().equals("X")) || (b5.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b5.getText().equals("")) || (b5.getText()==null))
                    {
                        b5.setText("X");
                    }
                }
                else if(source==b6)
                {
                    //verifica se ja foi jogado neste botao
                    if((b6.getText().equals("X")) || (b6.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b6.getText().equals("")) || (b6.getText()==null))
                    {
                        b6.setText("X");
                    }
                }
                else if(source==b7)
                {
                    //verifica se ja foi jogado neste botao
                    if((b7.getText().equals("X")) || (b7.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b7.getText().equals("")) || (b7.getText()==null))
                    {
                        b7.setText("X");
                    }
                }
                else if(source==b8)
                {
                    //verifica se ja foi jogado neste botao
                    if((b8.getText().equals("X")) || (b8.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b8.getText().equals("")) || (b8.getText()==null))
                    {
                        b8.setText("X");
                    }
                }
                else if(source==b9)
                {
                    //verifica se ja foi jogado neste botao
                    if((b9.getText().equals("X")) || (b9.getText().equals("O")))
                    {
                        JOptionPane.showMessageDialog(null,"vc num ta vendo que já jogaram aqui pôô!!!");
                    }
                    //apos verificar se pode jogar neste botao, eh setada a jogada do gamer
                    else if((b9.getText().equals("")) || (b9.getText()==null))
                    {
                        b9.setText("X");
                    }
                }

                //novamente eh verificado se houve ganhador
                if(vencedor()==0)
                {
                  //java ganhou
                  //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
                  JOptionPane.showMessageDialog(null,"Seu perdedor... o Java ganhou, vc eh muito ruim !!!\n vai lavar a loça da mamãe.");
                  dp.placar(this.vencedor());
                }
                else if(vencedor()==1)
                {
                  //gamer ganhou
                  //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
                  JOptionPane.showMessageDialog(null,"eh... vc ganhou do java, mais foi pura sorte \n tenta de novo se for macho!!!");
                  dp.placar(this.vencedor());
                }
                else if(vencedor()==-2)
                {
                  //ninguem ganhou
                  //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
                  JOptionPane.showMessageDialog(null,"aff... como vc eh ruim!!! \n nunca vai ganhar do java!!!");
                }
                else
                {
                    //terceiro eh setada a jogada do java
                    //temos que verificar as posicoes que o gamer jogou e as bloquear
                    //e logo apos contra atacar

                    if((b1.getText().equals("X")) && (b2.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b1.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b1.getText().equals("X")) && (b4.getText().equals("X")))
                    {
                        b7.setText("O");
                    }
                    else if((b2.getText().equals("X")) && (b1.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b2.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b8.setText("O");
                    }
                    else if((b3.getText().equals("X")) && (b2.getText().equals("X")))
                    {
                        b1.setText("O");
                    }
                    else if((b3.getText().equals("X")) && (b6.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b3.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b7.setText("O");
                    }
                    else if((b4.getText().equals("X")) && (b1.getText().equals("X")))
                    {
                        b7.setText("O");
                    }
                    else if((b4.getText().equals("X")) && (b7.getText().equals("X")))
                    {
                        b1.setText("O");
                    }
                    else if((b4.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b6.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b1.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b9.getText().equals("X")))
                    {
                        b1.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b4.getText().equals("X")))
                    {
                        b6.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b6.getText().equals("X")))
                    {
                        b4.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b7.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b3.getText().equals("X")))
                    {
                        b7.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b8.getText().equals("X")))
                    {
                        b2.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b9.getText().equals("X")))
                    {
                        b1.setText("O");
                    }
                    else if((b5.getText().equals("X")) && (b1.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b6.getText().equals("X")) && (b3.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b6.getText().equals("X")) && (b9.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b6.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b4.setText("O");
                    }
                    else if((b6.getText().equals("X")) && (b9.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b7.getText().equals("X")) && (b4.getText().equals("X")))
                    {
                        b1.setText("O");
                    }
                    else if((b7.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b7.getText().equals("X")) && (b8.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b8.getText().equals("X")) && (b7.getText().equals("X")))
                    {
                        b9.setText("O");
                    }
                    else if((b8.getText().equals("X")) && (b9.getText().equals("X")))
                    {
                        b7.setText("O");
                    }
                    else if((b9.getText().equals("X")) && (b6.getText().equals("X")))
                    {
                        b3.setText("O");
                    }
                    else if((b9.getText().equals("X")) && (b5.getText().equals("X")))
                    {
                        b1.setText("O");
                    }
                    else if((b9.getText().equals("X")) && (b8.getText().equals("X")))
                    {
                        b7.setText("O");
                    }
                    else if(b1.getText().equals(""))
                    {
                        b1.setText("O");
                    }
                    else if(b2.getText().equals(""))
                    {
                        b2.setText("O");
                    }
                    else if(b3.getText().equals("X"))
                    {
                        b3.setText("O");
                    }
                    else if(b4.getText().equals("X"))
                    {
                        b4.setText("O");
                    }
                    else if(b5.getText().equals("X"))
                    {
                        b5.setText("O");
                    }
                    else if(b6.getText().equals("X"))
                    {
                        b6.setText("O");
                    }
                    else if(b7.getText().equals("X"))
                    {
                        b7.setText("O");
                    }
                    else if(b8.getText().equals("X"))
                    {
                        b8.setText("O");
                    }
                    else if(b9.getText().equals("X"))
                    {
                        b9.setText("O");
                    }

                    ////novamente eh verificado se houve ganhador
                    if(vencedor()==0)
                    {
                      //if sem acao
                      //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
                      JOptionPane.showMessageDialog(null,"Seu perdedor... o Java ganhou, vc eh muito ruim !!!\n vai lavar a loça da mamãe.");
                      dp.placar(this.vencedor());
                    }
                    //gamer vencedor
                    else if(vencedor()==1)
                    {
                      //if sem acao
                      //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
                      JOptionPane.showMessageDialog(null,"eh... vc ganhou do java, mais foi pura sorte \n tenta de novo se for macho!!!");
                      dp.placar(this.vencedor());
                    }
                    else if(vencedor()==-2)
                    {
                      //if sem acao
                      //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
                      JOptionPane.showMessageDialog(null,"aff... como vc eh ruim!!! \n nunca vai ganhar do java!!!");
                    }
                }
            }
            //se java vencedor
            else if(vencedor()==0)
            {
              //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
              JOptionPane.showMessageDialog(null,"Seu perdedor... o Java ganhou, vc eh muito ruim !!!\n vai lavar a loça da mamãe.");
            }
            //gamer vencedor
            else if(vencedor()==1)
            {
              //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
              JOptionPane.showMessageDialog(null,"eh... vc ganhou do java, mais foi pura sorte \n tenta de novo se for macho!!!");
            }
            else if(vencedor()==-2)
            {
              //aguardando resposta do gamer p/ reiniciar o game ou proxima partida
              JOptionPane.showMessageDialog(null,"aff... como vc eh ruim!!! \n nunca vai ganhar do java!!!");
            }
        }

        public int vencedor()
        {
            int result;
            result=-1;

            //verificacao se o gamer ganhou
            if((b1.getText().equals("X")) && (b2.getText().equals("X")) && (b3.getText().equals("X")))
            {
                result=1;
            }
            else if((b1.getText().equals("X")) && (b3.getText().equals("X")) && (b2.getText().equals("X")))
            {
                result=1;
            }
            else if((b1.getText().equals("X")) && (b5.getText().equals("X")) && (b9.getText().equals("X")))
            {
                result=1;
            }
            else if((b1.getText().equals("X")) && (b9.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b1.getText().equals("X")) && (b4.getText().equals("X")) && (b7.getText().equals("X")))
            {
                result=1;
            }
            else if((b1.getText().equals("X")) && (b7.getText().equals("X")) && (b4.getText().equals("X")))
            {
                result=1;
            }
            else if((b2.getText().equals("X")) && (b1.getText().equals("X")) && (b3.getText().equals("X")))
            {
                result=1;
            }
            else if((b2.getText().equals("X")) && (b3.getText().equals("X")) && (b1.getText().equals("X")))
            {
                result=1;
            }
            else if((b2.getText().equals("X")) && (b5.getText().equals("X")) && (b8.getText().equals("X")))
            {
                result=1;
            }
            else if((b2.getText().equals("X")) && (b8.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b3.getText().equals("X")) && (b2.getText().equals("X")) && (b1.getText().equals("X")))
            {
                result=1;
            }
            else if((b3.getText().equals("X")) && (b1.getText().equals("X")) && (b2.getText().equals("X")))
            {
                result=1;
            }
            else if((b3.getText().equals("X")) && (b5.getText().equals("X")) && (b7.getText().equals("X")))
            {
                result=1;
            }
            else if((b3.getText().equals("X")) && (b7.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b3.getText().equals("X")) && (b9.getText().equals("X")) && (b6.getText().equals("X")))
            {
                result=1;
            }
            else if((b3.getText().equals("X")) && (b6.getText().equals("X")) && (b9.getText().equals("X")))
            {
                result=1;
            }
            else if((b4.getText().equals("X")) && (b1.getText().equals("X")) && (b7.getText().equals("X")))
            {
                result=1;
            }
            else if((b4.getText().equals("X")) && (b7.getText().equals("X")) && (b1.getText().equals("X")))
            {
                result=1;
            }
            else if((b4.getText().equals("X")) && (b5.getText().equals("X")) && (b6.getText().equals("X")))
            {
                result=1;
            }
            else if((b4.getText().equals("X")) && (b6.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b1.getText().equals("X")) && (b9.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b9.getText().equals("X")) && (b1.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b4.getText().equals("X")) && (b6.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b6.getText().equals("X")) && (b4.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b7.getText().equals("X")) && (b3.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b3.getText().equals("X")) && (b7.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b8.getText().equals("X")) && (b2.getText().equals("X")))
            {
                result=1;
            }
            else if((b5.getText().equals("X")) && (b2.getText().equals("X")) && (b8.getText().equals("X")))
            {
                result=1;
            }
            else if((b6.getText().equals("X")) && (b3.getText().equals("X")) && (b9.getText().equals("X")))
            {
                result=1;
            }
            else if((b6.getText().equals("X")) && (b9.getText().equals("X")) && (b3.getText().equals("X")))
            {
                result=1;
            }
            else if((b6.getText().equals("X")) && (b5.getText().equals("X")) && (b4.getText().equals("X")))
            {
                result=1;
            }
            else if((b6.getText().equals("X")) && (b4.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b7.getText().equals("X")) && (b4.getText().equals("X")) && (b1.getText().equals("X")))
            {
                result=1;
            }
            else if((b7.getText().equals("X")) && (b1.getText().equals("X")) && (b4.getText().equals("X")))
            {
                result=1;
            }
            else if((b7.getText().equals("X")) && (b5.getText().equals("X")) && (b3.getText().equals("X")))
            {
                result=1;
            }
            else if((b7.getText().equals("X")) && (b3.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b7.getText().equals("X")) && (b8.getText().equals("X")) && (b9.getText().equals("X")))
            {
                result=1;
            }
            else if((b7.getText().equals("X")) && (b9.getText().equals("X")) && (b8.getText().equals("X")))
            {
                result=1;
            }
            else if((b8.getText().equals("X")) && (b7.getText().equals("X")) && (b9.getText().equals("X")))
            {
                result=1;
            }
            else if((b8.getText().equals("X")) && (b9.getText().equals("X")) && (b7.getText().equals("X")))
            {
                result=1;
            }
            else if((b8.getText().equals("X")) && (b5.getText().equals("X")) && (b2.getText().equals("X")))
            {
                result=1;
            }
            else if((b8.getText().equals("X")) && (b2.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b9.getText().equals("X")) && (b6.getText().equals("X")) && (b3.getText().equals("X")))
            {
                result=1;
            }
            else if((b9.getText().equals("X")) && (b3.getText().equals("X")) && (b6.getText().equals("X")))
            {
                result=1;
            }
            else if((b9.getText().equals("X")) && (b5.getText().equals("X")) && (b1.getText().equals("X")))
            {
                result=1;
            }
            else if((b9.getText().equals("X")) && (b1.getText().equals("X")) && (b5.getText().equals("X")))
            {
                result=1;
            }
            else if((b9.getText().equals("X")) && (b7.getText().equals("X")) && (b8.getText().equals("X")))
            {
                result=1;
            }
            else if((b9.getText().equals("X")) && (b8.getText().equals("X")) && (b7.getText().equals("X")))
            {
                result=1;
            }

            //verificacao se o Java ganhou
            if((b1.getText().equals("O")) && (b2.getText().equals("O")) && (b3.getText().equals("O")))
            {
                result=0;
            }
            else if((b1.getText().equals("O")) && (b3.getText().equals("O")) && (b2.getText().equals("O")))
            {
                result=0;
            }
            else if((b1.getText().equals("O")) && (b5.getText().equals("O")) && (b9.getText().equals("O")))
            {
                result=0;
            }
            else if((b1.getText().equals("O")) && (b9.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b1.getText().equals("O")) && (b4.getText().equals("O")) && (b7.getText().equals("O")))
            {
                result=0;
            }
            else if((b1.getText().equals("O")) && (b7.getText().equals("O")) && (b4.getText().equals("O")))
            {
                result=0;
            }
            else if((b2.getText().equals("O")) && (b1.getText().equals("O")) && (b3.getText().equals("O")))
            {
                result=0;
            }
            else if((b2.getText().equals("O")) && (b3.getText().equals("O")) && (b1.getText().equals("O")))
            {
                result=0;
            }
            else if((b2.getText().equals("O")) && (b5.getText().equals("O")) && (b8.getText().equals("O")))
            {
                result=0;
            }
            else if((b2.getText().equals("O")) && (b8.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b3.getText().equals("O")) && (b2.getText().equals("O")) && (b1.getText().equals("O")))
            {
                result=0;
            }
            else if((b3.getText().equals("O")) && (b1.getText().equals("O")) && (b2.getText().equals("O")))
            {
                result=0;
            }
            else if((b3.getText().equals("O")) && (b5.getText().equals("O")) && (b7.getText().equals("O")))
            {
                result=0;
            }
            else if((b3.getText().equals("O")) && (b7.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b3.getText().equals("O")) && (b9.getText().equals("O")) && (b6.getText().equals("O")))
            {
                result=0;
            }
            else if((b3.getText().equals("O")) && (b6.getText().equals("O")) && (b9.getText().equals("O")))
            {
                result=0;
            }
            else if((b4.getText().equals("O")) && (b1.getText().equals("O")) && (b7.getText().equals("O")))
            {
                result=0;
            }
            else if((b4.getText().equals("O")) && (b7.getText().equals("O")) && (b1.getText().equals("O")))
            {
                result=0;
            }
            else if((b4.getText().equals("O")) && (b5.getText().equals("O")) && (b6.getText().equals("O")))
            {
                result=0;
            }
            else if((b4.getText().equals("O")) && (b6.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b1.getText().equals("O")) && (b9.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b9.getText().equals("O")) && (b1.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b4.getText().equals("O")) && (b6.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b6.getText().equals("O")) && (b4.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b7.getText().equals("O")) && (b3.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b3.getText().equals("O")) && (b7.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b8.getText().equals("O")) && (b2.getText().equals("O")))
            {
                result=0;
            }
            else if((b5.getText().equals("O")) && (b2.getText().equals("O")) && (b8.getText().equals("O")))
            {
                result=0;
            }
            else if((b6.getText().equals("O")) && (b3.getText().equals("O")) && (b9.getText().equals("O")))
            {
                result=0;
            }
            else if((b6.getText().equals("O")) && (b9.getText().equals("O")) && (b3.getText().equals("O")))
            {
                result=0;
            }
            else if((b6.getText().equals("O")) && (b5.getText().equals("O")) && (b4.getText().equals("O")))
            {
                result=0;
            }
            else if((b6.getText().equals("O")) && (b4.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b7.getText().equals("O")) && (b4.getText().equals("O")) && (b1.getText().equals("O")))
            {
                result=0;
            }
            else if((b7.getText().equals("O")) && (b1.getText().equals("O")) && (b4.getText().equals("O")))
            {
                result=0;
            }
            else if((b7.getText().equals("O")) && (b5.getText().equals("O")) && (b3.getText().equals("O")))
            {
                result=0;
            }
            else if((b7.getText().equals("O")) && (b3.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b7.getText().equals("O")) && (b8.getText().equals("O")) && (b9.getText().equals("O")))
            {
                result=0;
            }
            else if((b7.getText().equals("O")) && (b9.getText().equals("O")) && (b8.getText().equals("O")))
            {
                result=0;
            }
            else if((b8.getText().equals("O")) && (b7.getText().equals("O")) && (b9.getText().equals("O")))
            {
                result=0;
            }
            else if((b8.getText().equals("O")) && (b9.getText().equals("O")) && (b7.getText().equals("O")))
            {
                result=0;
            }
            else if((b8.getText().equals("O")) && (b5.getText().equals("O")) && (b2.getText().equals("O")))
            {
                result=0;
            }
            else if((b8.getText().equals("O")) && (b2.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b9.getText().equals("O")) && (b6.getText().equals("O")) && (b3.getText().equals("O")))
            {
                result=0;
            }
            else if((b9.getText().equals("O")) && (b3.getText().equals("O")) && (b6.getText().equals("O")))
            {
                result=0;
            }
            else if((b9.getText().equals("O")) && (b5.getText().equals("O")) && (b1.getText().equals("O")))
            {
                result=0;
            }
            else if((b9.getText().equals("O")) && (b1.getText().equals("O")) && (b5.getText().equals("O")))
            {
                result=0;
            }
            else if((b9.getText().equals("O")) && (b7.getText().equals("O")) && (b8.getText().equals("O")))
            {
                result=0;
            }
            else if((b9.getText().equals("O")) && (b8.getText().equals("O")) && (b7.getText().equals("O")))
            {
                result=0;
            }
            //condicao para verificacao de caso nao exista nenhum ganhador
            else if
            (
                (!(b1.getText().equals(""))) && (!(b2.getText().equals(""))) && (!(b2.getText().equals(""))) &&
                (!(b4.getText().equals(""))) && (!(b5.getText().equals(""))) && (!(b6.getText().equals(""))) &&
                (!(b7.getText().equals(""))) && (!(b8.getText().equals(""))) && (!(b9.getText().equals("")))
            )
            {
                JOptionPane.showMessageDialog(null,"ihh...  Tente novamente!!!");
                result=-2;
            }
            return result;
        }
    }


    class events implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source;
            source=event.getSource();

            if(source==exit)
            {
                System.exit(0);
            }
            else if(source==info)
            {
                JOptionPane.showMessageDialog(null, "este programa foi feito pela" +
            "TFSystems e esta licenciado pela gnu 2.0 \n para reportar bugs contate o desenvolvedor \n"+
            "marcosptf@yahoo.com.br");
            }
        }

    }

    class new_game  implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {

            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            display_gamer.setText("0");
            display_java.setText("0");

        }


    }

    class next_game implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
        }

    }

    class display implements ActionListener
    {
       int content =-3;

       public int placar(int vl)
       {
           return content=vl;
       }

        public void actionPerformed(ActionEvent event)
        {
            placar pc = new placar();
            if(pc.getGPlacar()==0)
            {
                 pc.setGPlacar(0);
                 display_gamer.setText("0");
            }
            if(pc.getJPlacar()==0)
            {
                 pc.setJPlacar(0);
                 display_java.setText("0");
            }

            if(this.content==0)
            {
                //java
                pc.setJPlacar(pc.getJPlacar()+1);
                if(pc.getJPlacar()==1)
                {
                    display_java.setText("1");
                }
                else if(pc.getJPlacar()==2)
                {
                    display_java.setText("2");
                }
                else if(pc.getJPlacar()==3)
                {
                    display_java.setText("3");
                }
                else if(pc.getJPlacar()==4)
                {
                    display_java.setText("4");
                }
                else if(pc.getJPlacar()==5)
                {
                    display_java.setText("5");
                }
            }
            else if(this.content==1)
            {
              //gamer
                pc.setGPlacar(pc.getGPlacar()+1);
                if(pc.getGPlacar()==1)
                {
                    display_gamer.setText("1");
                }
                else if(pc.getJPlacar()==2)
                {
                    display_gamer.setText("2");
                }
                else if(pc.getJPlacar()==3)
                {
                    display_gamer.setText("3");
                }
                else if(pc.getJPlacar()==4)
                {
                    display_gamer.setText("4");
                }
                else if(pc.getJPlacar()==5)
                {
                    display_gamer.setText("5");
                }
            }
        }
    }

    class placar
    {
        public int getGPlacar()
        {
            return Gplacar;
        }

        public void setGPlacar(int pc)
        {
            Gplacar=pc;
        }
        public int getJPlacar()
        {
            return Jplacar;
        }

        public void setJPlacar(int pc)
        {
            Jplacar=pc;
        }
    }
}