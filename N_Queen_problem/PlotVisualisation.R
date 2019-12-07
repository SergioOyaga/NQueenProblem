library(bigvis)
library(tidyverse)
library(ggplot2)

############## Set the working directory in the Juego_Ajedrez folder. #####################

tibble_8Q=as_tibble(read.csv(file = "archivo.csv",header = T))

ggplot(data=tibble_8Q,aes(x=Generation,y=Mean,color=Type.of.crossover))+
  scale_color_manual(values=c("#F300FF","#feba04","#0024b6","#51FF33"))+
  geom_smooth(alpha=1, size=1,se=F) +
  geom_point(alpha=0.2) +
  theme(legend.justification=c(1,1), legend.position=c(1,1))+
  theme(legend.background = element_rect(fill="gray90", size=.5))+
  ggtitle("Populations fitness mean.")+
  scale_x_continuous(limit = c(0,1000))

ggplot(data=tibble_8Q,aes(x=Generation,y=Best,color=Type.of.crossover))+
  scale_color_manual(values=c("#F300FF","#feba04","#0024b6","#51FF33"))+
  geom_point(alpha=1) +
  theme(legend.justification=c(1,1), legend.position=c(1,1))+
  theme(legend.background = element_rect(fill="gray90", size=.5))+
  ggtitle("Comparation between the best individual from each technique.")+
  scale_x_continuous(limit = c(0,200))

tibble_8Q
  

tibble_8Q2=as_tibble(read.csv(file = "archivo1.csv",header = T))

ggplot(data=tibble_8Q2,aes(x=fitness,fill=name))+
  facet_grid(. ~ Type.of.crossover, scales="free")+
  geom_histogram(binwidth=1,colour="black")+
  theme(legend.position="none")+
  ggtitle("Genomes convergence around the minimum.")
