tabel = {"unknown" : 0,"correct" : 1,"wrong" : 2,"time limit exceeded" : 3,"running" : 4,"queued" : 5,"runtime error" : 6,"compilation error" : 7,"memory limit exceeded" : 8, "internal error" : 9}

def getCursus(jaar):
    output = []
    x = open("cgi-bin/bestanden/courses.tsv")
    for line in x:
        if line.split("\t")[2] == jaar:
            output.append(line.split("\t")[1])
    return output

