library(bigvis)
library(tidyverse)
library(ggplot2)

# Set the working directory where the files ale placed or edit the full path in each file read.
tibble_8Q=as_tibble(read.csv(file = "file.csv",header = T))
tibble_8Q2=as_tibble(read.csv(file = "file1.csv",header = T))
generations = 200 #Adjust the length to the number of generations used in the java code.

ggplot(data=tibble_8Q,aes(x=Generation,y=Mean,color=Type.of.crossover))+
  scale_color_manual(values=c("#F300FF","#feba04","#0024b6","#51FF33"))+
  geom_smooth(alpha=1, size=1,se=F) +
  geom_point(alpha=0.2) +
  theme(legend.justification=c(1,1), legend.position=c(1,1))+
  theme(legend.background = element_rect(fill="gray90", size=.5))+
  ggtitle("Populations fitness mean.")+
  scale_x_continuous(limit = c(0,generations))

ggplot(data=tibble_8Q,aes(x=Generation,y=Best,color=Type.of.crossover))+
  scale_color_manual(values=c("#F300FF","#feba04","#0024b6","#51FF33"))+
  geom_point(alpha=1) +
  theme(legend.justification=c(1,1), legend.position=c(1,1))+
  theme(legend.background = element_rect(fill="gray90", size=.5))+
  ggtitle("Comparation between the best individual from each technique.")+
  scale_x_continuous(limit = c(0,generations))


ggplot(data=tibble_8Q2,aes(x=fitness,fill=name))+
  facet_grid(. ~ Type.of.crossover, scales="free")+
  geom_histogram(binwidth=1,colour="black")+
  theme(legend.position="none")+
  ggtitle("Genomes convergence around the minimum.")
