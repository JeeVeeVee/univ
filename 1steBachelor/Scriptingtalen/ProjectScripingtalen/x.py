tabel = {"unknown" : 0,"correct" : 1,"wrong" : 2,"time limit exceeded" : 3,"running" : 4,"queued" : 5,"runtime error" : 6,"compilation error" : 7,"memory limit exceeded" : 8, "internal error" : 9}




def getFout(fout, jaar):
    foutnummer = tabel[fout]
    output = dict()
    test = getCursus(jaar)
    print(test)
    check = []
    courses = open("cgi-bin/bestanden/courses.tsv")
    for course in courses:
        splitted = course.split("\t")
        if splitted[2] == jaar:
            output[splitted[0]] = 0
            check.append(splitted[0])

    print(check)
    submissions = open("cgi-bin/bestanden/submissions.tsv")
    for line in submissions:
        splitted = line[:-1].split("\t")
        #print(splitted)
        if splitted[4] == str(foutnummer):
            #print(line)
            if splitted[6] in check:
                output[splitted[6]] += 1
    for x in output:
        print(x, getCursusFromID(x), output[x])


def getCursusFromID(ID):
    courses = open("cgi-bin/bestanden/courses.tsv")
    for course in courses:
        splitted = course.split("\t")
        if splitted[0] == ID:
            return splitted[1]




print(getFout("wrong", "2017-2018"))
